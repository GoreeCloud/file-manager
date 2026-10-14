#!/usr/bin/env python3
"""Static safety contract for development-only Linux distribution definitions."""
from pathlib import Path
import json

ROOT = Path(__file__).resolve().parents[1]
PKG = ROOT / "packaging" / "flatpak"
manifest = json.loads((PKG / "com.goreecloud.FileManager.Development.json").read_text())
assert manifest["app-id"] == "com.goreecloud.FileManager.Development"
assert manifest["branch"] == "development"
assert manifest["runtime-version"] == "26.08"
assert manifest["command"] == "goreecloud-file-manager-development"
permissions = set(manifest["finish-args"])
assert "--filesystem=home:ro" in permissions
assert "--share=network" not in permissions
assert not any(p.startswith("--filesystem=host") or
               (p.startswith("--filesystem=") and not p.endswith(":ro"))
               for p in permissions), "Unexpected read-write or host filesystem permission"
module, = manifest["modules"]
sources = module["sources"]
assert sources[0] == {
    "type": "dir", "path": "../../linux-desktop/build/compose/binaries/main/app"
}
for src in sources[1:]:
    assert src["type"] == "file"
    assert (PKG / src["path"]).is_file(), src["path"]
launcher = (PKG / "goreecloud-file-manager-development").read_text()
assert 'exec /app/opt/goreecloud-file-manager/bin/goreecloud-file-manager-dev "$@"' in launcher
desktop = (PKG / "com.goreecloud.FileManager.Development.desktop").read_text()
assert "Exec=goreecloud-file-manager-development" in desktop
assert "MimeType=" not in desktop
gradle = (ROOT / "linux-desktop/build.gradle.kts").read_text()
for marker in ("TargetFormat.Deb", 'packageName = "goreecloud-file-manager-dev"',
               'packageVersion = "0.1.0"'):
    assert marker in gradle, marker
print("Linux development packaging contract validated")
