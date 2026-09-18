package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme =
  darkColorScheme(
    primary = LiveCyanPrimary,
    onPrimary = Color(0xFF00363F),
    primaryContainer = LiveCyanContainer,
    onPrimaryContainer = LiveCyanOnContainer,
    secondary = AmberAccent,
    onSecondary = Color(0xFF3E2800),
    secondaryContainer = AmberContainer,
    onSecondaryContainer = Color(0xFFFFD54F),
    tertiary = LiveRed,
    onTertiary = Color.White,
    tertiaryContainer = LiveRedContainer,
    onTertiaryContainer = Color(0xFFFFB3BA),
    background = DarkBackground,
    onBackground = TextPrimary,
    surface = DarkSurface,
    onSurface = TextPrimary,
    surfaceVariant = DarkSurfaceElevated,
    onSurfaceVariant = TextSecondary,
    outline = DarkSurfaceBorder,
    outlineVariant = Color(0xFF1E2638)
  )

@Composable
fun MyApplicationTheme(
  content: @Composable () -> Unit,
) {
  MaterialTheme(
    colorScheme = DarkColorScheme,
    typography = Typography,
    content = content
  )
}

