package uz.otamurod.organize

import kotlinx.cinterop.ExperimentalForeignApi
import kotlin.experimental.ExperimentalNativeApi
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalForeignApi::class, ExperimentalNativeApi::class)
actual class PlatformTest {
    private val platform = Platform()
    
    @Test
    actual fun testOperatingSystemName() {
        assertTrue(
            actual = platform.osName.equals(
                "iOS",
                ignoreCase = true
            ) || platform.osName == "iPadOS",
            message = "The OS name should either be iOS or iPadOS."
        )
    }
}