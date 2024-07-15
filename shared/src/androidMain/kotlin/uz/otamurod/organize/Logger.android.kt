package uz.otamurod.organize

import android.util.Log

actual class Logger {
    actual companion object {
        actual fun log(
            message: String?,
            tag: String,
            level: LogLevel
        ) {
            if (message == null) {
                return
            }
            
            when (level) {
                LogLevel.DEBUG -> Log.d(tag, message)
                LogLevel.WARN -> Log.w(tag, message)
                LogLevel.ERROR -> Log.e(tag, message)
            }
        }
    }
}