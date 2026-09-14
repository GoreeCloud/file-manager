# GoreeCloud File Manager — Conformance and Acceptance

## Current lifecycle

**Active Android development with shared-core and bounded Linux-provider development, read-only location discovery, a merged development-only Linux desktop presentation surface, and an active GLAZE UI V1.4 / Platform Contract 0.3 migration candidate. Production and Stable eligibility: false.**

Linux and Android are required first-class native product platforms. Android remains the only declared supported platform. Authoritative main `acbabdcb86eb5a9a1cdb907be613c5d0954a7447` contains the shared JVM `:core` module, bounded Linux local-filesystem provider, read-only Home/XDG/mount location discovery, non-production command-line harness, and Compose Desktop development surface for explicit location selection and read-only folder browsing. This does **not** establish an accepted Linux desktop client, supported Linux package, production runtime, or Stable Linux support.

The active `platform/glaze-v1.4-contract-v0.3-20260914` candidate is based on that main revision. It carries forward the still-unmerged exact-resource/unknown-destination-size transfer hardening from Draft PR #15 and advances the Android presentation source mapping to current Stable GLAZE UI V1.4 / `1.4.0`, together with Platform Contract `0.3`. Exact-head CI remains required before this candidate's changes count as validated Development evidence.

The current development milestone distinguishes four levels of truth:

1. shared/core and Linux development source is present and the Linux desktop Development stack is merged;
2. presentation source may exist without rendered/native conformance acceptance;
3. exact-head workflow completion is required before a new candidate's source/build checks count as evidence;
4. successful development CI does not establish native desktop/package/runtime/Stable acceptance.

| Gate | Required baseline | Current File Manager state | Production gate |
| --- | --- | --- | --- |
| Native application model | Original GoreeCloud-owned product | Native Android application plus shared-core/platform-adapter architecture and Linux desktop Development presentation source established | In progress |
| Required platform scope | First-class Linux + Android | Android native client exists; Linux provider/discovery/desktop-development source exists; accepted desktop client/package/runtime absent | Blocked |
| Shared cross-platform core | Platform-neutral provider/resource/operation/evidence contracts | `:core` consumed by Android and Linux development modules; active transfer hardening still requires current exact-head validation/integration | In progress |
| Android storage authorization | Least-privilege, provider-bounded access | App-private confinement plus user-selected persisted document trees implemented | In progress |
| Linux filesystem/provider integration | Native bounded Linux filesystem/provider behavior | Explicit-root provider, symlink/path/mount safeguards, read-only Home/XDG/mount discovery, explicit-open desktop controller, tests, harness, and Linux workflow are merged; broader desktop/provider acceptance incomplete | In progress / blocked for production |
| Core file operations | Safe, capability-aware, reconcilable operations | Bounded mutation + exact-resource SHA-256-verified ordinary-file transfer foundation; Linux desktop surface intentionally exposes browsing only; complete UI/Trash/recursive workflows incomplete | Blocked |
| Glaze UI | GLAZE UI V1.4 / 1.4.0 Stable | Active Android candidate pins exact V1.4 source authority and fail-closed optical rules; Linux desktop source requires V1.4 migration; rendered/native/accessibility/device acceptance incomplete | Blocked |
| Wardveil Security | Current approved Wardveil contracts | Adapter boundary only; no accepted runtime evidence | Blocked |
| Privacy Shield | Current approved Privacy Shield contract/runtime authority | Adapter boundary only; no accepted runtime evidence | Blocked |
| Everkeep | Current approved continuity/recovery contract | Adapter boundary only; no accepted runtime evidence | Blocked |
| GoreeCloud Identity | Current approved identity/access authority | Adapter boundary only | Blocked |
| GoreeCloud Mesh | Current approved coordination/evidence profile | Adapter boundary only | Blocked |
| GoreeCloud Manager | Current approved management/lifecycle authority | Adapter boundary only | Blocked |
| GoreeCloud Sync | Explicit Platform Contract 0.3 declaration plus independently accepted synchronization behavior | Explicitly declared applicable-blocked; no accepted change tracking, conflict/version coordination, authorized replication, offline resume, or cross-device runtime | Blocked |

`goreecloud.platform.yaml` intentionally remains Android-only in `supported_platforms` until Linux satisfies the machine-readable supported-platform evidence requirements. Linux provider, discovery, desktop-development source, or passing Development CI is not sufficient reason to broaden that field.

## Android storage acceptance boundary

The current Storage Access Framework integration is a least-privilege source implementation:

- broader storage is selected through Android's system document-tree picker;
- File Manager requests persistable read permission and write permission when granted;
- persisted permissions are used to reconstruct authorized locations;
- resource identity remains bounded to the selected tree authority and tree document ID;
- mutation UI is driven by persisted authorization plus provider-reported document capabilities;
- the selected document tree is not falsely classified as local disk when its provider type is unknown.

This source behavior still requires representative-device/provider validation. It does not establish support for every Android DocumentsProvider.

## Linux development acceptance boundary

The current `LinuxFileRepository` is a deliberately bounded source implementation, not the final Linux filesystem contract.

Current source safeguards include:

- one explicit existing root directory per provider instance;
- provider-relative IDs and normalized root confinement;
- selected root may not itself be a symbolic link;
- metadata inspection with `NOFOLLOW_LINKS`;
- symbolic links represented as non-traversable/non-mutable `SYMLINK` resources in the current slice;
- symbolic-link component traversal rejected;
- operating-system readability/writability respected;
- mutation capability withheld when a resource's `FileStore` differs from the selected root's store;
- provider root rename/delete rejected;
- recursive directory deletion refused;
- shared verified ordinary-file copy/move supported by provider primitives and exercised in Linux test source;
- command-line development harness accepts one explicit root and exposes read-only listing only.

The current `LinuxLocationDiscovery` layer is separately bounded and **does not grant provider access**. It may discover:

- the current Home directory;
- recognized XDG user directories from `user-dirs.dirs`;
- user-facing mounted filesystems parsed from `/proc/self/mountinfo`;
- `/media` and `/run/media` paths as removable-media **candidates**.

All discovery entries require explicit selection before File Manager constructs a provider. XDG parsing expands only literal `$HOME` / `${HOME}` forms or accepts explicit absolute paths; it does not execute shell expressions. Discovery includes only existing non-symlink directories under its current checks, filters ordinary pseudo/system-only mount surfaces, and does not treat a removable-media candidate as proof of hardware removability, safe-eject support, or mutation authority.

`LinuxDevelopmentMain --locations` exposes only this read-only candidate report. The existing explicit-root mode remains a separate provider-access engineering boundary. No discovered location is automatically opened, authorized, or made mutable.

### Desktop development presentation boundary

`LinuxDesktopDevelopmentMain` is a development-only Compose Multiplatform Desktop surface. It is a genuine desktop presentation layer rather than a relabeled CLI harness, but its existence is not desktop acceptance.

`LinuxDesktopController` preserves discovery versus authorization structurally:

- controller initialization may discover candidates but does not construct a provider;
- highlighting a candidate does not construct a provider;
- only an explicit **Open location** action may invoke the provider factory for that selected path;
- failed explicit open clears the attempted provider state instead of pretending authorization succeeded;
- folder navigation accepts only folders from the currently authorized provider ID;
- returning to Locations clears the active provider/current-location boundary;
- the desktop UI exposes browsing/navigation only and does not surface the provider's mutation primitives in this milestone.

The merged source composition provides an edge-integrated location sidebar, responsive toolbar, solid file-content plane, contextual inspector, and explicit status/error/boundary presentation. Those choices are Development implementation evidence only. The Linux surface still requires explicit current V1.4 migration plus rendered/native accessibility, reduced-transparency/contrast/motion, keyboard/pointer, representative-desktop, and human-visual acceptance.

Exact-head Linux development CI is required to establish candidate-specific source/build/test evidence for Linux behavior. The workflow checks repository contracts, shared-core/Linux tests including the desktop controller, Compose Desktop source compilation, JVM development-distribution construction, explicit-root smoke behavior, a distribution digest, and an explicit development-only artifact boundary.

Even after those checks pass, Linux production acceptance still requires representative native desktop rendering and accessibility/input review; accepted user-facing XDG/navigation behavior; mount/removable-media lifecycle and safe-eject integration; reviewed permissions/ownership/symlink policy beyond the bounded slice; applicable file-association/Open With and drag-and-drop behavior; supported distribution/desktop-environment scope; accepted package/signing/release provenance; representative runtime testing; current Glaze acceptance; and applicable Platform-System evidence.

Android source/build evidence cannot be reused as Linux acceptance.

## Mutation and transfer acceptance boundary

Current provider operations distinguish successful, rejected, and failed results. App-private path confinement, shared transfer integrity/failure behavior, and Linux bounded provider safety behavior have corresponding test source.

The active candidate carries forward Draft PR #15's transfer-verification hardening onto current main. Destination identity must match the exact resource returned by `createFile`; verification never falls back to a same-name resource. Destination size metadata is treated only as an optional early consistency signal: when both source and destination sizes are known and unequal, the transfer fails early; when destination size is unavailable, the exact destination resource must still pass byte-level SHA-256 readback verification. Move never removes the source until destination verification succeeds.

Recursive folder deletion and recursive folder transfer are deliberately refused. Complete destination-selection copy/move UI, duplicate/create-file UI, multi-selection, conflict handling, durable Operations Center, unified Trash, rollback/recovery, and platform-authority preflight remain incomplete. Therefore broad destructive-operation acceptance is blocked.

The Linux desktop Development surface deliberately exposes no mutation UI even where the underlying provider reports mutation capabilities.

A provider reporting a filesystem capability does not establish Privacy Shield authorization, Wardveil approval, backup protection, Everkeep recoverability, or Sync acceptance.

## GLAZE UI V1.4 acceptance requirements

File Manager may claim current-Stable Glaze UI alignment only after its exact revision demonstrates repository-local **GLAZE UI V1.4 / `1.4.0`** adoption, automated validation, rendered/native accessibility, responsive/form-factor behavior, state presentation, representative platform behavior, and all applicable Human Visual / V1.4.1 acceptance appropriate to each supported Linux and Android context.

The active Android candidate pins Stable GLAZE UI V1.4 source revision `84cb3db4884042f0fa25ed6d475a127fb110f596`, replaces wallpaper-derived dynamic color selection with a bounded neutral light/dark source mapping, defines 48 dp ordinary and 56 dp Touch Assistance reference floors, and keeps Environmental Color Memory influence at 0% for this bounded mapping.

File names, file contents, provider identity, operation state, platform-authority state, remote context, and telemetry may not drive optical adaptation. Reduced Transparency and forced-color source behavior resolve to solid-accessible treatment. The source contract deliberately keeps Optical Engine, Reduced Transparency, Increased Contrast, representative Android/Linux, and human-visual acceptance false.

These source rules are not a conformance certificate. Android still requires rendered/native accessibility, adaptive/form-factor, representative-device/provider, performance, rollback, and human-visual validation. The Linux desktop Development surface requires its own V1.4 mapping and independent acceptance.

The reusable Platform Contract workflow is pinned to authoritative central main commit `908701c6795ffcd608bd3d8a1e787395a04f1d62`, which carries Platform Contract `0.3`. A successful contract run proves only the machine contract checks performed for that exact caller revision; it does **not** upgrade application-specific Glaze UI, security, privacy, recovery, Sync, Linux desktop, or Stable acceptance.

## Wardveil claim rules

A file may be represented with a positive Wardveil security outcome only when the application has current authoritative Wardveil evidence for the exact resource/content scope and applicable evidence is valid. Unsupported, stale, expired, unavailable, unknown, or unverified coverage cannot become a clean/protected claim.

## Privacy Shield claim rules

Operating-system resource authorization, Android document-tree authorization, Linux filesystem access, or file ownership does not itself establish privacy authorization for indexing, remote processing, telemetry, sharing, synchronization, backup, or other distinct purposes. Privacy-relevant operations must use current applicable Privacy Shield authority. Missing runtime acceptance blocks a positive Privacy Shield coverage claim.

## Everkeep claim rules

`backup exists`, `integrity verified`, `restore tested`, and `recoverable` are distinct states. File Manager must not show verified recoverability unless the applicable Everkeep/backup evidence establishes it for the resource and recovery scope.

## GoreeCloud Sync claim rules

File copies, duplicate resources, provider synchronization indicators, ordinary transfer integrity, GoreeCloud Drive availability, backup existence, or Everkeep recovery evidence do not establish GoreeCloud Sync acceptance. Positive Sync state requires its own accepted change tracking, version/conflict behavior, authorization, replication, offline-resume, and cross-device evidence.

## Source/build acceptance

An exact development revision is expected to pass all applicable checks for the platform code present in that revision.

Current Android workflow checks include:

- exact source-revision checkout and recording;
- repository/document validation, including the required `USER-MANUAL.md`;
- shared-core unit tests;
- Android unit tests, including the V1.4 source-contract tests on the active candidate;
- Android lint;
- development APK assembly;
- package/application-label verification;
- exact-revision artifact publication.

Current Linux development workflow checks include:

- exact source-revision checkout and recording;
- repository/document validation;
- shared-core unit tests;
- Linux provider, location-discovery, and desktop-controller unit tests;
- Compose Desktop development-source compilation;
- JVM development-distribution construction;
- explicit-root development-harness smoke test;
- distribution SHA-256 digest;
- an evidence file stating that the artifact and desktop compilation are Development evidence, not accepted Linux desktop/package/Stable proof.

The shared Platform Contract workflow remains an independent required gate and is pinned to authoritative central Platform Contract 0.3 main revision `908701c6795ffcd608bd3d8a1e787395a04f1d62`.

Passing source/build checks establishes only the checks actually performed for that exact revision. It does not establish platform-runtime production acceptance, representative-platform compatibility, production signing/deployment, Linux desktop/package support, complete mount/removable-media lifecycle behavior, complete Platform-System integration, or Stable qualification.
