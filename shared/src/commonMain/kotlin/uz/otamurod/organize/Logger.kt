package uz.otamurod.organize

enum class LogLevel {
    DEBUG, WARN, ERROR
}

expect class Logger {
    companion object {
        fun log(
            message: String?,
            tag: String = "Organize",
            level: LogLevel = LogLevel.DEBUG
        )
    }
}