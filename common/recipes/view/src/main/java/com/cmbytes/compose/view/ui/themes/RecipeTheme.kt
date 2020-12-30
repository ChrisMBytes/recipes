package com.cmbytes.compose.view.ui.themes

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColors(
    primary = Color.White,
    primaryVariant = Color.White,
    onPrimary = Color.Black,
    secondary = Green400,
    secondaryVariant = Green400,
    onSecondary = Color.White,
)

@Composable
fun RecipeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        LightColors
    } else {
        LightColors
    }

    MaterialTheme(
        colors = colors,
        content = content
    )
}

