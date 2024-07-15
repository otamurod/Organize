package uz.otamurod.organize

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
            print("${level.name}/$tag: $message")
        }
    }
}