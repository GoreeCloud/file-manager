# GoreeCloud File Manager — Project Record

**Repository:** `GoreeCloud/file-manager`  
**Former repository identity in the Drive source:** `GoreeCloud/goreecloud-file-manager`  
**Lifecycle:** Development  
**Record purpose:** Significant cross-platform architecture history, repository rename provenance, accepted Development milestones, candidate boundaries, and project-specification migration evidence  
**Migration baseline:** `acbabdcb86eb5a9a1cdb907be613c5d0954a7447`  
**Canonical authority:** This file is the repository-local project record once accepted on the default branch.

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

## Project governance migration

This migration:
- creates root `PROJECT-SPECIFICATIONS.md`;
- creates root `PROJECT-RECORD.md`;
- consolidates the former root `SPECIFICATIONS.md`;
- reconciles the repository rename;
- removes stale Drive project-specification/changelog authority from the canonical specification and README;
- converts `FEATURE-ROADMAP.md` from an active Drive-synchronized control into temporary repository migration input; and
- retires the duplicate root `SPECIFICATIONS.md` after incorporation.

**Drive source:** Project Specification — File Manager.docx  
**Drive file ID:** `1tfhaFl-OuuDUqn0jLLYtiBLiNmHZ44ix`  
**Drive deletion status:** Blocked until the migration is accepted, authoritative default-branch readback succeeds, review/check gates pass, and no unresolved reconciliation discrepancy remains.

## Separate feature/changelog migration debt

File Manager does not yet have the complete mandatory repository-native `IMPLEMENTED-FEATURES.md`, `PLANNED-FEATURES.md`, and `CHANGELOGS.md` control set.

That migration is separate from this project-specification/project-record tranche. The legacy `FEATURE-ROADMAP.md` must remain temporary migration input until those records are created and accepted; it must not be synchronized back to Drive.

Any historical Drive changelog/roadmap material must remain protected until that separate migration is verified. This project-specification migration does not claim those sources are safe to delete.

## Ongoing maintenance

Update this project record for significant architecture, provider/resource identity changes, Linux/Android platform acceptance, repository changes, security/privacy/recovery events, production/deployment changes, lifecycle promotion, split/merge/rename, migration, or retirement.

Routine accepted feature/fix chronology should move to the mandatory repository-native changelog once that separate governance migration is completed.
