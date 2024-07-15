package ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val lightColorScheme = lightColorScheme(
    primary = ColorPrimary,
    primaryContainer = ColorPrimaryDark,
    secondary = ColorAccent
    
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}