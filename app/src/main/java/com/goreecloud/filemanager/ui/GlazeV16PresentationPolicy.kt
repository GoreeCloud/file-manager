package com.goreecloud.filemanager.ui

/**
 * Bounded source-level mapping to the current Stable GLAZE UI V1.6 authority.
 *
 * This policy is presentation-only. It cannot grant provider access, infer privacy/security truth,
 * execute destructive operations, or establish rendered/native conformance by itself.
 */
internal object GlazeV16PresentationPolicy {
    const val stableVersion = "1.6.0"
    const val stableSourceRevision = "a7180679ea851389e0f3004515f9a25f420e716d"
    const val platformContractVersion = "0.4"
    const val platformContractRevision = "e49b9afdea094c96a36a0457b1603f2fa8e8fa6b"

    const val colorOnlyMeaningAllowed = false
    const val mayInferPrivacyState = false
    const val mayInferSecurityState = false
    const val mayGrantAuthorization = false

    fun minimumTouchTargetDp(touchAssistance: Boolean): Int =
        if (touchAssistance) 56 else 48
}
