#!/usr/bin/env bash
# Development-only isolated sandbox and GUI checks on disposable Actions runner.
set -euo pipefail
if [[ "$CI" != "true" || "$GITHUB_ACTIONS" != "true" ]]; then
  echo "Refusing Flatpak installation outside disposable CI" >&2; exit 2
fi
bundle="$(realpath "$1")"
[[ -s "$bundle" ]]
app="com.goreecloud.FileManager.Development"
flatpak install --user --noninteractive -y "$bundle"
cleanup() { flatpak uninstall --user --noninteractive -y "$app" >/dev/null || true; }
trap cleanup EXIT
[[ "$(flatpak info --user --show-ref "$app")" == "app/$app/x86_64/development" ]]
permissions="$(flatpak info --user --show-permissions "$app")"
printf '%s\n' "$permissions"
grep -Fq 'filesystems=home:ro;' <<<"$permissions"
if grep -Fq 'network' <<<"$permissions"; then
  echo "Unexpected Flatpak network capability" >&2; exit 1
fi
probe="$HOME/goreecloud-ci-flatpak-read-only-probe"
mkdir -p "$probe"
printf 'synthetic test fixture\n' >"$probe/fixture.txt"
trap 'flatpak uninstall --user --noninteractive -y "$app" >/dev/null || true; rm -rf -- "$probe"' EXIT
flatpak run --user --command=sh "$app" -c '
  test -r "$HOME/goreecloud-ci-flatpak-read-only-probe/fixture.txt" || exit 41
  if (printf denied > "$HOME/goreecloud-ci-flatpak-read-only-probe/blocked.txt") 2>/dev/null; then
    echo "Unexpected sandbox home write" >&2; exit 42
  fi
'
[[ ! -e "$probe/blocked.txt" ]]
export GOREECLOUD_SMOKE_LOG="$RUNNER_TEMP/flatpak-gui-smoke.log"
xvfb-run -a bash scripts/smoke_linux_window.sh flatpak run --user --env=SKIKO_RENDER_API=SOFTWARE "$app"
echo "Flatpak sandbox constraints and graphical startup verified"
flatpak uninstall --user --noninteractive -y "$app"
rm -rf -- "$probe"
trap - EXIT
if flatpak info --user "$app" >/dev/null 2>&1; then
  echo "Flatpak still installed after uninstall" >&2; exit 1
fi
echo "Flatpak clean removal verified"
