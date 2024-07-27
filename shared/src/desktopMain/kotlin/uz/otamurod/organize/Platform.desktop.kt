package uz.otamurod.organize

import java.awt.Toolkit

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class Platform actual constructor() {
    actual val osName = System.getProperty("os.name") ?: "Desktop"
    
    actual val osVersion = System.getProperty("os.version") ?: "---"
    
    actual val deviceModel = "Desktop"
    
    actual val cpuType = System.getProperty("os.arch") ?: "---"
    
    actual val screen = ScreenInfo()
    
    actual fun logSystemInfo() {
        print(deviceInfo)
    }
}

actual class ScreenInfo actual constructor() {
    private val toolkit = Toolkit.getDefaultToolkit()
    
    actual val width = toolkit.screenSize.width
    actual val height = toolkit.screenSize.height
    actual val density: Int? = null
}