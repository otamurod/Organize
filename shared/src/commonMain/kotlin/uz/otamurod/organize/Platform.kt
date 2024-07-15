package uz.otamurod.organize

expect class Platform() {
    val osName: String
    val osVersion: String
    
    val deviceModel: String
    val cpuType: String
    
    val screen: ScreenInfo
    
    fun logSystemInfo()
}

expect class ScreenInfo() {
    val width: Int
    val height: Int
    val density: Int?
}

val Platform.deviceInfo: String
    get() {
        var result = "($osName; $osVersion; $deviceModel; ${screen.width}x${screen.height}"
        
        screen.density?.let {
            result += "@${it}x; "
        }
        
        result += "$cpuType)"
        return result
    }