# GoreeCloud File Manager — Feature Roadmap

**Status:** Active roadmap control  
**Required native platforms:** Linux and Android  
**Authoritative project record:** `GoreeCloud/Projects/Project Specification — File Manager`  
**Canonical repository:** `GoreeCloud/goreecloud-file-manager`  
**Drive counterpart:** `GoreeCloud/Feature Roadmap/GoreeCloud File Manager/FEATURE-ROADMAP.docx`

This roadmap records active File Manager feature obligations and implementation status without replacing the authoritative project specification, repository implementation evidence, release gates, or GoreeCloud Tasks Management. A feature is not complete or Stable merely because it appears here.

The repository and Drive roadmap copies must remain materially synchronized. Status changes require authoritative implementation/validation evidence, and historical checkpoints must remain historically truthful.

Current authoritative main `acbabdcb86eb5a9a1cdb907be613c5d0954a7447` integrates the validated Linux desktop Development stack from PRs #16–#19 while preserving Android-only `supported_platforms`. The pre-merge exact heads passed their recorded Linux Development, Android Foundation, and Platform Contract checks; that evidence remains Development evidence only. The active `platform/glaze-v1.4-contract-v0.3-20260914` candidate is based on that main revision, carries forward the still-unmerged exact-resource transfer hardening from PR #15, and advances current Stable GLAZE UI V1.4 / `1.4.0` plus Platform Contract `0.3` source declarations. Exact-head validation of the new candidate remains required before its changes count as validated Development evidence.

## Status vocabulary

- **Validated development foundation** — merged source/build behavior has exact-revision validation but is not production/Stable acceptance.
- **Active** — implementation work is currently actionable or in progress.
- **Planned** — required/recommended work remains outstanding.
- **Blocked on prerequisite** — intentionally held until a stated safety/authority prerequisite exists.
- **Ongoing control** — governance obligation that remains continuously active.

## Roadmap

| ID | Feature / obligation | Priority | Current state |
| --- | --- | --- | --- |
| FR-001 | Reconcile every current planned or recommended File Manager feature against the authoritative project record and verified repository evidence. | High | Ongoing control |
| FR-002 | Move actionable feature obligations into GoreeCloud Tasks Management when required, preserving priority, dependency, and lifecycle disposition. | High | Ongoing control |
| FR-003 | Do not mark features implemented, complete, cancelled, or superseded without authoritative evidence and synchronized repository/Drive roadmap updates. | High | Ongoing control |
| FR-010 | Maintain Linux and Android as first-class native product targets without transferring one platform's storage identity, permissions, or acceptance evidence to the other. | High | Active; Android remains the only declared supported platform, while Linux has a merged native desktop Development stack below supported-platform acceptance |
| FR-011 | Shared platform-neutral provider/resource/operation/evidence core with verified ordinary-file transfer semantics. | High | Validated development foundation on authoritative main; exact-resource identity and unknown-destination-size transfer verification from Draft PR #15 are carried forward on the active V1.4/Contract 0.3 candidate and still require exact-head validation/integration |
| FR-012 | Linux desktop location discovery for Home/XDG user directories plus mounted-filesystem and removable-media candidates, while keeping discovery separate from explicit provider authorization. | High | Validated Development foundation integrated into authoritative main; pre-merge PR #18 exact head `746fb02e7ce11e58e5513f933d9eeaff1b8ac8e1` passed Linux Development `34539264117` and Android Foundation `34539264157`. Representative mount/remount/unplug and safe-eject acceptance remain open. |
| FR-013 | Native Linux desktop Glaze UI V1.4 surface with accessible desktop information architecture, context/action presentation, and current consumer conformance evidence. | High | Active; native Linux desktop Development surface is merged on main, while current V1.4 source mapping plus rendered/accessibility/representative-platform acceptance remain incomplete |
| FR-014 | Linux keyboard/pointer navigation, focus behavior, accessible names/state, screen-reader behavior, reduced-motion/scaling, and drag alternatives. | High | Validated Development foundation integrated into main from PR #19. Pre-merge implementation head `c3b6db18bc351aa1cf4b3036cd93fbca054dc8ce` passed Linux Development `34544051630` and Android Foundation `34544051619`; full focus-order, visible-focus, screen-reader, scaling/reduced-motion, representative keyboard/pointer, and drag-alternative acceptance remain open. |
| FR-015 | Linux file associations, Open With, reveal/open handoff, and desktop integration. | Medium | Planned |
| FR-016 | Linux clipboard file operations and drag-and-drop with provider-aware identity, capability, conflict, and recovery semantics. | High | Planned |
| FR-017 | Linux windows, tabs, context menus, split/dual-pane workflows, workspace restoration, and desktop density. | Medium | Planned |
| FR-018 | Supported Linux package/distribution matrix, dependency review, signing, release/rollback controls, and representative runtime acceptance. | High | Blocked on native desktop/runtime acceptance |
| FR-020 | Android user-facing destination-selection copy/move workflows over the verified shared transfer service, with explicit conflicts and reconciliation. | High | Planned |
| FR-021 | Multi-selection and durable/reconcilable Operations Center for file operations and transfers. | High | Planned |
| FR-022 | Unified Trash/recovery plus Backup/Everkeep evidence and destructive-operation safeguards before recursive deletion or recursive folder transfer. | High | Blocked on recovery/continuity prerequisites |
| FR-023 | GoreeCloud Drive and GoreeCloud Sync runtime providers with provider-scoped identity, offline/conflict state, and verified transfers. | High | Planned |
| FR-024 | Runtime Privacy Shield, Wardveil Security, Everkeep, GoreeCloud Identity, GoreeCloud Mesh, applicable GoreeCloud Manager integration, and separately governed GoreeCloud Sync runtime acceptance under independent authority boundaries. | High | Planned |
| FR-025 | Search/indexing, previews, tags, collections, sharing, file details, provenance, storage intelligence, and smart discovery under applicable privacy/security authority. | Medium | Planned |
| FR-026 | Representative Android and Linux device/provider/distribution/accessibility/input/performance validation tied to exact release revisions. | High | Planned |
| FR-027 | Migrate File Manager source declarations and Android presentation mapping to current Stable GLAZE UI V1.4 / `1.4.0` and Platform Contract `0.3` without manufacturing platform acceptance. | High | Active on `platform/glaze-v1.4-contract-v0.3-20260914`; bounded source mapping, fail-closed optical tests, Contract 0.3 declaration, explicit Sync contract state, and current central validator pin are present, while exact-head CI and application acceptance remain required |

## Current acceptance boundary

`goreecloud.platform.yaml` remains Android-only in `supported_platforms`. The Linux shared-core/provider/build foundation and native desktop Development surface are real and merged, but Linux still requires system integration, supported packaging, representative rendered/runtime/accessibility/input evidence, Platform-System acceptance, signing/release controls, and explicit lifecycle qualification before it may be represented as a currently supported or Stable platform.

The active V1.4/Platform Contract 0.3 candidate does not itself establish GLAZE UI acceptance. Its source contract intentionally keeps Optical Engine, Reduced Transparency, Increased Contrast, representative Android/Linux platform, and human-visual acceptance false until the required evidence exists. GoreeCloud Sync is declared in the 0.3 machine contract while remaining distinct from file transfer, backup/recovery, provider duplication, and the higher-level authorization boundaries documented for the product.
