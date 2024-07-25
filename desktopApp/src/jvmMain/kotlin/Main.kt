import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import org.koin.core.Koin
import ui.about.AboutView
import ui.reminders.RemindersView
import ui.theme.AppTheme
import uz.otamurod.organize.Logger
import uz.otamurod.organize.initKoin
import uz.otamurod.organize.presentation.Screen

lateinit var koin: Koin
    private set

fun main() {
    koin = initKoin().koin
    
    return application {
        var screenState by remember { mutableStateOf(Screen.Reminders) }
        
        AppTheme {
            Window(
                title = "Organize",
                state = rememberWindowState(width = 400.dp, height = 550.dp),
                resizable = true,
                onCloseRequest = ::exitApplication,
            ) {
                RemindersView(
                    onAboutButtonClick = {
                        screenState = Screen.AboutDevice
                        Logger.log("Navigating to About Device Window\n")
                    }
                )
            }
            
            if (screenState == Screen.AboutDevice) {
                Window(
                    title = "About Device",
                    state = WindowState(width = 300.dp, height = 450.dp),
                    resizable = true,
                    onCloseRequest = {
                        screenState = Screen.Reminders
                        Logger.log("Closing About Device Window\n")
                    },
                ) {
                    AboutView()
                }
            }
        }
        Logger.log("Desktop app is running...\n")
    }
}