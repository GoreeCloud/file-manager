package com.goreecloud.filemanager.ui

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class GlazeFoundationPolicyTest {
    @Test
    fun stableAuthorityIsPinnedToCurrentV16ReleaseAndContract() {
        assertEquals("1.6.0", GlazeUiFoundation.currentStableTarget)
        assertEquals(
            "a7180679ea851389e0f3004515f9a25f420e716d",
            GlazeUiFoundation.currentStableSourceRevision,
        )
        assertEquals("0.4", GlazeV16PresentationPolicy.platformContractVersion)
        assertEquals(
            "e49b9afdea094c96a36a0457b1603f2fa8e8fa6b",
            GlazeV16PresentationPolicy.platformContractRevision,
        )
    }

    @Test
    fun presentationPolicyRemainsFailClosedForAuthorityTruth() {
        assertFalse(GlazeV16PresentationPolicy.colorOnlyMeaningAllowed)
        assertFalse(GlazeV16PresentationPolicy.mayInferPrivacyState)
        assertFalse(GlazeV16PresentationPolicy.mayInferSecurityState)
        assertFalse(GlazeV16PresentationPolicy.mayGrantAuthorization)
        assertEquals(48, GlazeV16PresentationPolicy.minimumTouchTargetDp(touchAssistance = false))
        assertEquals(56, GlazeV16PresentationPolicy.minimumTouchTargetDp(touchAssistance = true))
    }
}
