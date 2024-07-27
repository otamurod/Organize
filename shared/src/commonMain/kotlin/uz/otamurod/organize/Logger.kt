package uz.otamurod.organize

enum class LogLevel {
    DEBUG, WARN, ERROR
}

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class Logger {
    companion object {
        fun log(
            message: String?,
            tag: String = "Organize",
            level: LogLevel = LogLevel.DEBUG
        )
    }
}