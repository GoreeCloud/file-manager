#!/usr/bin/env bash
# Verify a native development window appears and the launcher stays alive.
set -euo pipefail
: "$GOREECLOUD_SMOKE_LOG"
if (( $# < 1 )); then echo "Missing launcher" >&2; exit 2; fi
"$@" >"$GOREECLOUD_SMOKE_LOG" 2>&1 &
app_pid=$!
cleanup() {
  if kill -0 "$app_pid" 2>/dev/null; then kill -TERM "$app_pid" 2>/dev/null || true; fi
  wait "$app_pid" 2>/dev/null || true
}
trap cleanup EXIT
for ((attempt = 0; attempt < 30; attempt++)); do
  window_id="$(xdotool search --onlyvisible --name 'GoreeCloud File Manager' 2>/dev/null | head -n 1 || true)"
  if [[ -n "$window_id" ]]; then
    title="$(xdotool getwindowname "$window_id")"
    [[ "$title" == *'GoreeCloud File Manager'* ]] || exit 1
    kill -0 "$app_pid"
    echo "Visible development window: $title"
    exit 0
  fi
  if ! kill -0 "$app_pid" 2>/dev/null; then
    echo "Launcher exited before window appeared" >&2
    cat "$GOREECLOUD_SMOKE_LOG" >&2
    exit 1
  fi
  sleep 1
done
echo "No visible development window within 30s" >&2
cat "$GOREECLOUD_SMOKE_LOG" >&2
exit 1
