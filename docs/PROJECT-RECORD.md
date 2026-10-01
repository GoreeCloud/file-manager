# GoreeCloud File Manager — Project Record

**Repository:** `GoreeCloud/file-manager`  
**Former repository identity in the Drive source:** `GoreeCloud/goreecloud-file-manager`  
**Lifecycle:** Development  
**Record purpose:** Significant cross-platform architecture history, repository rename provenance, accepted Development milestones, candidate boundaries, and project-specification migration evidence  
**Migration baseline:** `471b10d4a349e347c1d986c702a8a55b4af8adcc`  
**Canonical path:** `docs/PROJECT-RECORD.md`  
**Canonical authority:** This file becomes the repository-local project record once accepted on the default branch.

## Product and architecture decision

GoreeCloud File Manager is an original GoreeCloud-owned file manager with Linux and Android as required first-class native product targets.

One platform's paths, URIs, permissions, packaging, runtime behavior, or acceptance evidence must not be treated as authority for the other. Shared provider/resource identity and operation semantics live in platform-neutral code where appropriate, while platform adapters preserve OS-native authorization and lifecycle boundaries.

## Current accepted baseline

At migration baseline `acbabdcb86eb5a9a1cdb907be613c5d0954a7447`, authoritative `main` includes:
- the Android native Development application;
- a shared JVM `:core` model;
- Android app-private and Storage Access Framework provider foundations;
- verified ordinary-file transfer semantics;
- a bounded Linux local-filesystem provider;
- Linux Home/XDG/mount location-candidate discovery;
- a non-production Linux development harness;
- an integrated Linux desktop Development stack through the former PR #16–#19 line; and
- explicit Development/non-Stable acceptance boundaries.

Android remains the only declared supported platform in machine-readable conformance at this baseline. Linux source existence is not equivalent to supported Linux production acceptance.

## Repository rename reconciliation

The Drive specification and older repository documents name `GoreeCloud/goreecloud-file-manager`. The current authoritative repository is `GoreeCloud/file-manager`.

The old name remains historical provenance only. New project records, links, migration evidence, pull requests, and authority references must use the current repository identity.

## Drive project-specification history

The Drive source contains 33 numbered sections. Sections 1–21 define product scope and provider/platform-system responsibilities. Sections 22–33 accumulate Development checkpoints and governance/history, including:

- an August 29 current-source checkpoint;
- current restrictions;
- production/Stable promotion gates and long-term direction;
- create-file/duplicate and provider-generic verified-transfer checkpoints;
- canonical visual identity;
- Linux-and-Android native-platform requirements;
- merged shared-core/bounded Linux provider work;
- Linux location-discovery work;
- exact-resource transfer verification/unknown-size compatibility; and
- Linux desktop Development, stale-provider safety, and keyboard-navigation work.

These checkpoint statements remain exact-revision history. They do not override newer accepted `main` or promote later Draft branches.

## Current Draft candidates

Live GitHub contains Draft PR #20 and #21 based on the migration baseline.

PR #21 carries newer Platform Contract and Glaze source-authority work than authoritative `main`. It remains candidate-only until reviewed, accepted, merged, and read back from `main`.

## 2026-09-27 — Repository-native feature-state migration integrated

PR #23 merged as authoritative main `471b10d4a349e347c1d986c702a8a55b4af8adcc`. The repository now maintains feature state through `IMPLEMENTED-FEATURES.md`, `PLANNED-FEATURES.md`, and `CHANGELOGS.md`; the legacy `FEATURE-ROADMAP.md` was retired and preserved only as historical migration source. This later project-governance migration must not recreate the retired roadmap or restore Drive synchronization authority.

## 2026-10-01 — Project governance migration reconciled

The earlier PR #22 was based on pre-feature-migration main and became non-mergeable after PR #23 advanced authoritative state. Its unique project-specification/project-record work is rebuilt from current main under `docs/` to comply with the repository-root documentation organization standard.

This migration:
- creates `docs/PROJECT-SPECIFICATIONS.md`;
- creates `docs/PROJECT-RECORD.md`;
- consolidates and retires the former root `SPECIFICATIONS.md`;
- reconciles the repository rename;
- updates README navigation and authority language;
- updates repository validation to the canonical docs paths; and
- leaves current repository-native feature-state records and runtime source unchanged.

**Drive source:** Project Specification — File Manager.docx  
**Drive file ID:** `1tfhaFl-OuuDUqn0jLLYtiBLiNmHZ44ix`  
**Drive deletion status:** Blocked until the migration is accepted, authoritative default-branch readback succeeds, review/check gates pass, and no unresolved reconciliation discrepancy remains.

## Feature/changelog migration state

The repository-native feature/changelog migration is complete on current main through PR #23. `IMPLEMENTED-FEATURES.md`, `PLANNED-FEATURES.md`, and `CHANGELOGS.md` are the active repository feature-state records. Historical Drive roadmap/changelog material remains subject to its own source-retirement evidence and must not be revived as current authority.

## Ongoing maintenance

Update this project record for significant architecture, provider/resource identity changes, Linux/Android platform acceptance, repository changes, security/privacy/recovery events, production/deployment changes, lifecycle promotion, split/merge/rename, migration, or retirement.

Routine accepted feature/fix chronology should move to the mandatory repository-native changelog once that separate governance migration is completed.
