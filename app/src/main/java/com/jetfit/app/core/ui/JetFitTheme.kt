package com.jetfit.app.core.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val JetFitColors = darkColorScheme(
    primary = Color(0xFFFFC107),
    onPrimary = Color(0xFF241A00),
    secondary = Color(0xFF64B5F6),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onBackground = Color(0xFFF5F5F5),
    onSurface = Color(0xFFF5F5F5)
)

@Composable
fun JetFitTheme(content: @Composable () -> Unit) {
    MaterialTheme(colorScheme = JetFitColors, content = content)
}
