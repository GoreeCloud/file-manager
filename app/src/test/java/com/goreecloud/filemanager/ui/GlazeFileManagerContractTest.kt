package com.goreecloud.filemanager.ui

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class GlazeFileManagerContractTest {
    @Test
    fun sourceMappingPinsCurrentStableV16Authority() {
        assertEquals("1.6.0", GlazeUiFoundation.currentStableTarget)
        assertEquals(
            "a7180679ea851389e0f3004515f9a25f420e716d",
            GlazeUiFoundation.currentStableSourceRevision,
        )
        assertEquals("ADOPTION_IN_PROGRESS", GlazeUiFoundation.adoptionState)
        assertEquals(48f, GlazeUiFoundation.minimumTouchTarget.value)
        assertEquals(56f, GlazeUiFoundation.touchAssistanceTarget.value)
    }

    @Test
    fun applicationAcceptanceRemainsFailClosed() {
        assertFalse(GlazeUiFoundation.opticalEngineAccepted)
        assertFalse(GlazeUiFoundation.reducedTransparencyAccepted)
        assertFalse(GlazeUiFoundation.increasedContrastAccepted)
        assertFalse(GlazeUiFoundation.representativeAndroidAccepted)
        assertFalse(GlazeUiFoundation.representativeLinuxAccepted)
        assertFalse(GlazeUiFoundation.humanVisualAccepted)
    }

    @Test
    fun ordinaryOpticsRemainNeutralSemanticAndContentIndependent() {
        val state = GlazeFileManagerOptics.resolve()

        assertEquals(GlazeFileManagerOptics.State.Mode.NEUTRAL_OPTICAL, state.mode)
        assertEquals(1f, state.semanticProtection)
        assertEquals(0f, state.environmentalColorMemoryInfluence)
        assertFalse(state.decorativeTintAllowed)
    }

    @Test
    fun accessibilityModesFailClosedWithoutDecorativeAuthority() {
        val reduced = GlazeFileManagerOptics.resolve(
            GlazeFileManagerOptics.Accessibility(reducedTransparency = true),
        )
        val forced = GlazeFileManagerOptics.resolve(
            GlazeFileManagerOptics.Accessibility(forcedColors = true),
        )
        val contrast = GlazeFileManagerOptics.resolve(
            GlazeFileManagerOptics.Accessibility(increasedContrast = true),
        )

        for (state in listOf(reduced, forced)) {
            assertEquals(GlazeFileManagerOptics.State.Mode.SOLID_ACCESSIBLE, state.mode)
            assertEquals(0f, state.blurScale)
            assertEquals(1f, state.semanticProtection)
            assertFalse(state.decorativeTintAllowed)
        }
        assertTrue(contrast.blurScale < GlazeFileManagerOptics.resolve().blurScale)
        assertFalse(contrast.decorativeTintAllowed)
    }

    @Test
    fun fileAndAuthorityStateCanNeverDriveOptics() {
        assertEquals(0f, GlazeFileManagerOptics.MAX_ENVIRONMENTAL_COLOR_MEMORY_INFLUENCE)
        assertFalse(GlazeFileManagerOptics.FILE_NAME_MAY_DRIVE_OPTICS)
        assertFalse(GlazeFileManagerOptics.FILE_CONTENT_MAY_DRIVE_OPTICS)
        assertFalse(GlazeFileManagerOptics.PROVIDER_IDENTITY_MAY_DRIVE_OPTICS)
        assertFalse(GlazeFileManagerOptics.OPERATION_STATE_MAY_DRIVE_OPTICS)
        assertFalse(GlazeFileManagerOptics.PLATFORM_AUTHORITY_STATE_MAY_DRIVE_OPTICS)
        assertFalse(GlazeFileManagerOptics.REMOTE_CONTEXT_ALLOWED)
        assertFalse(GlazeFileManagerOptics.TELEMETRY_REQUIRED)
    }
}
