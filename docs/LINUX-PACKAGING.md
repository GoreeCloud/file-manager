# Linux development packages

GoreeCloud File Manager's Linux graphical application remains **Development-only**.
This pipeline creates opt-in test packages; no package is Stable, production ready,
or supported by a platform acceptance decision.

## Debian package

On an x86_64 Linux development host with JDK 17 (including jpackage),
Gradle 9.5.0, fakeroot, and dpkg-deb:

~~~sh
gradle :core:test :linux-client:test :linux-desktop:classes
python3 scripts/validate_linux_packaging.py
gradle :linux-desktop:packageDeb
dpkg-deb --info linux-desktop/build/compose/binaries/main/deb/*.deb
~~~

The resulting package name is goreecloud-file-manager-dev, Debian version 0.1.0-1.
Install only on an authorized test machine. Complete clean-install,
upgrade, uninstall, graphical input, accessibility, and data-boundary
testing before promoting any Linux build.

## Flatpak

The Flatpak bundles the **prebuilt Compose Desktop app image**, including its
packaged Java runtime. Flatpak does not download or compile application source
inside its sandbox. Install the freedesktop Platform and SDK version 26.08 from
your trusted Flatpak remote before building.

~~~sh
gradle :linux-desktop:createDistributable
python3 scripts/validate_linux_packaging.py
flatpak-builder --user --force-clean --repo=build/flatpak-repo   build/flatpak-work packaging/flatpak/com.goreecloud.FileManager.Development.json
flatpak build-bundle build/flatpak-repo   build/goreecloud-file-manager-development.flatpak   com.goreecloud.FileManager.Development development
~~~

**Development sandbox scope:** read-only access to the user's home directory,
Wayland/X11 fallback, and graphics acceleration. The package requests no
network access, writable home directory, or unrestricted host filesystem.
Provider selection remains explicit inside the app, and the UI is read-only.
This provisional home permission needs replacement with a file chooser portal
before Stable acceptance. Host mount/removable discovery is restricted by the
sandbox. The current desktop entry does not advertise external file handling.

## CI lifecycle

The Linux packaging workflow compiles the desktop, runs shared and Linux
provider tests, validates manifest permissions, creates package candidates,
checks package metadata and exercises installation on disposable CI runners.
The headless runner provisions standard XDG desktop-menu directories
before installing the Debian package; the packaging test still exercises
the real package post-install and pre-remove scripts. Debian is installed,
smoke-launched in a virtual X11 display, then purged.
Flatpak is installed, checked for sandbox read-only home access and absence
of network access, smoke-launched under virtual X11, then uninstalled.
A visible window does not prove full accessibility, upgrade/rollback support,
or representative desktop acceptance. Temporary GitHub Actions artifacts
include SHA-256 evidence; CI neither signs nor publishes a Release. Keep any user-facing download clearly
identified as a development candidate.

The existing Gradle runDevelopment target remains available. Android
distribution and production platform status are unchanged.
