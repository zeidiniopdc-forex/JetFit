package com.jetfit.app.core.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val Teal = Color(0xFF008F8C)
private val LightTeal = Color(0xFF4FC3C0)
private val Gold = Color(0xFFFFC107)

private val JetFitDarkColors = darkColorScheme(
    primary = Gold,
    onPrimary = Color(0xFF241A00),
    secondary = LightTeal,
    onSecondary = Color(0xFF00201F),
    tertiary = Color(0xFF64B5F6),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onBackground = Color(0xFFF5F5F5),
    onSurface = Color(0xFFF5F5F5)
)

private val JetFitLightColors = lightColorScheme(
    primary = Teal,
    onPrimary = Color.White,
    secondary = Gold,
    onSecondary = Color(0xFF241A00),
    tertiary = Color(0xFF1976D2),
    background = Color(0xFFF4FBFA),
    surface = Color.White,
    onBackground = Color(0xFF102020),
    onSurface = Color(0xFF102020)
)

@Composable
fun JetFitTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) JetFitDarkColors else JetFitLightColors,
        content = content
    )
}
