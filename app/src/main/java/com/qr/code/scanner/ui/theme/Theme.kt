package com.qr.code.scanner.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColorScheme(
    primary = Color(0xff616161),
    primaryContainer = Color(0xff373737),
)

private val LightColorPalette = lightColorScheme(
    primary = Color(0xff616161),
    primaryContainer = Color(0xff373737),
)

@Composable
fun QRCodeScannerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    useSystemUIController: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    if (useSystemUIController) {
        val systemUiController = rememberSystemUiController()
        systemUiController.setSystemBarsColor(
            color = colors.primaryContainer
        )
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content,
        shapes = Shapes
    )
}