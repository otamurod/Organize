package uz.otamurod.organize

import android.content.res.Resources
import android.os.Build
import android.util.Log
import kotlin.math.round

actual class Platform actual constructor() {
    actual val osName = "Android"
    
    @androidx.annotation.ChecksSdkIntAtLeast(extension = 0)
    actual val osVersion = "${Build.VERSION.SDK_INT}"
    
    actual val deviceModel = "${Build.MANUFACTURER} ${Build.MODEL}"
    
    actual val cpuType = Build.SUPPORTED_ABIS?.firstOrNull() ?: "---"
    
    actual val screen: ScreenInfo
        get() = ScreenInfo()
    
    actual fun logSystemInfo() {
        Log.d("Platform", deviceInfo)
    }
}

actual class ScreenInfo actual constructor() {
    private val metrics = Resources.getSystem().displayMetrics
    
    actual val width = metrics.widthPixels
    actual val height = metrics.heightPixels
    actual val density: Int? = round(metrics.density).toInt()
}