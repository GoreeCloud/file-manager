package com.goreecloud.filemanager.ui

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

object GlazeUiFoundation {
    const val currentStableTarget = GlazeV16PresentationPolicy.stableVersion
    const val currentStableSourceRevision = GlazeV16PresentationPolicy.stableSourceRevision
    val minimumTouchTarget = GlazeV16PresentationPolicy.minimumTouchTargetDp(touchAssistance = false).dp
    val touchAssistanceTarget = GlazeV16PresentationPolicy.minimumTouchTargetDp(touchAssistance = true).dp
}

@Composable
fun GoreeCloudFileManagerTheme(content: @Composable () -> Unit) {
    val context = LocalContext.current
    val dark = isSystemInDarkTheme()
    val scheme = when {
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && dark -> dynamicDarkColorScheme(context)
        Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> dynamicLightColorScheme(context)
        dark -> darkColorScheme()
        else -> lightColorScheme()
    }

    MaterialTheme(
        colorScheme = scheme,
        content = content,
    )
}
