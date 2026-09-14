package com.goreecloud.filemanager.ui

import android.content.res.Configuration
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

/**
 * Repository-local source boundary for GoreeCloud File Manager's current Stable GLAZE UI target.
 *
 * This is a bounded native mapping, not application acceptance. Presentation must never manufacture
 * provider authorization, resource identity, operation success, synchronization, backup/recovery,
 * privacy, security, Identity, Mesh, Manager, or Sync truth.
 */
object GlazeUiFoundation {
    const val currentStableTarget = "1.4.0"
    const val stableSourceRevision = "84cb3db4884042f0fa25ed6d475a127fb110f596"
    const val adoptionState = "ADOPTION_IN_PROGRESS"

    val minimumTouchTarget = 48.dp
    val touchAssistanceTarget = 56.dp

    const val opticalEngineAccepted = false
    const val reducedTransparencyAccepted = false
    const val increasedContrastAccepted = false
    const val representativeAndroidAccepted = false
    const val representativeLinuxAccepted = false
    const val humanVisualAccepted = false
}

/**
 * File Manager-specific V1.4 optical policy.
 *
 * Resource names, contents, provider identity, operation outcomes, and platform-authority state are
 * semantic/authority-bearing data and may not become environmental styling inputs. This resolver
 * consumes accessibility intent only and keeps Environmental Color Memory disabled for this bounded
 * Development mapping.
 */
object GlazeFileManagerOptics {
    const val MAX_ENVIRONMENTAL_COLOR_MEMORY_INFLUENCE = 0f
    const val FILE_NAME_MAY_DRIVE_OPTICS = false
    const val FILE_CONTENT_MAY_DRIVE_OPTICS = false
    const val PROVIDER_IDENTITY_MAY_DRIVE_OPTICS = false
    const val OPERATION_STATE_MAY_DRIVE_OPTICS = false
    const val PLATFORM_AUTHORITY_STATE_MAY_DRIVE_OPTICS = false
    const val REMOTE_CONTEXT_ALLOWED = false
    const val TELEMETRY_REQUIRED = false

    data class Accessibility(
        val reducedTransparency: Boolean = false,
        val increasedContrast: Boolean = false,
        val forcedColors: Boolean = false,
    )

    data class State(
        val mode: Mode,
        val blurScale: Float,
        val semanticProtection: Float,
        val decorativeTintAllowed: Boolean,
        val environmentalColorMemoryInfluence: Float,
    ) {
        enum class Mode { NEUTRAL_OPTICAL, SOLID_ACCESSIBLE }
    }

    fun resolve(accessibility: Accessibility = Accessibility()): State {
        if (accessibility.reducedTransparency || accessibility.forcedColors) {
            return State(
                mode = State.Mode.SOLID_ACCESSIBLE,
                blurScale = 0f,
                semanticProtection = 1f,
                decorativeTintAllowed = false,
                environmentalColorMemoryInfluence = 0f,
            )
        }

        return State(
            mode = State.Mode.NEUTRAL_OPTICAL,
            blurScale = if (accessibility.increasedContrast) 0.42f else 0.58f,
            semanticProtection = 1f,
            decorativeTintAllowed = false,
            environmentalColorMemoryInfluence = 0f,
        )
    }
}

private val LightFileManagerColors = lightColorScheme(
    primary = Color(0xFF356A84),
    onPrimary = Color.White,
    background = Color(0xFFF5F7FA),
    onBackground = Color(0xFF151A23),
    surface = Color(0xFFFDFEFF),
    onSurface = Color(0xFF151A23),
)

private val DarkFileManagerColors = darkColorScheme(
    primary = Color(0xFF8FC4DE),
    onPrimary = Color(0xFF08212D),
    background = Color(0xFF0B0D11),
    onBackground = Color(0xFFF5F7FA),
    surface = Color(0xFF15191E),
    onSurface = Color(0xFFF5F7FA),
)

@Composable
fun GoreeCloudFileManagerTheme(content: @Composable () -> Unit) {
    val dark = (LocalConfiguration.current.uiMode and Configuration.UI_MODE_NIGHT_MASK) ==
        Configuration.UI_MODE_NIGHT_YES

    MaterialTheme(
        colorScheme = if (dark) DarkFileManagerColors else LightFileManagerColors,
        content = content,
    )
}
