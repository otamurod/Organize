package uz.otamurod.organize

import platform.Foundation.NSLog

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
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
            NSLog("${level.name}/$tag: $message")
        }
    }
}