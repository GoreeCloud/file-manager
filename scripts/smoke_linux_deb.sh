#!/usr/bin/env bash
# System package mutations permitted only on disposable GitHub Actions runner.
set -euo pipefail
if [[ "$CI" != "true" || "$GITHUB_ACTIONS" != "true" ]]; then
  echo "Refusing system installation outside disposable CI" >&2; exit 2
fi
deb="$(realpath "$1")"
[[ -f "$deb" ]]
[[ "$(dpkg-deb --field "$deb" Package)" == "goreecloud-file-manager-dev" ]]
[[ "$(dpkg-deb --field "$deb" Version)" == "0.1.0-1" ]]
[[ "$(dpkg-deb --field "$deb" Architecture)" == "amd64" ]]
package="goreecloud-file-manager-dev"
launcher="/opt/$package/bin/$package"
sudo apt-get install -y "$deb"
cleanup() { sudo apt-get purge -y "$package" >/dev/null || true; }
trap cleanup EXIT
dpkg -s "$package" | grep -Fq 'Status: install ok installed'
[[ -x "$launcher" ]]
export GOREECLOUD_SMOKE_LOG="$RUNNER_TEMP/deb-gui-smoke.log"
SKIKO_RENDER_API=SOFTWARE xvfb-run -a bash scripts/smoke_linux_window.sh "$launcher"
echo "Debian application installed and displayed window"
sudo apt-get purge -y "$package"
trap - EXIT
if dpkg -s "$package" 2>/dev/null | grep -Fq 'Status: install ok installed'; then
  echo "Debian package still installed after purge" >&2; exit 1
fi
[[ ! -e "$launcher" ]]
echo "Debian package clean removal verified"
