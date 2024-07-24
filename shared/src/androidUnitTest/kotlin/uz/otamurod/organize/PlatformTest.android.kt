package uz.otamurod.organize

import org.junit.Test
import kotlin.test.assertEquals

actual class PlatformTest {
    private val platform = Platform()
    
    @Test
    actual fun testOperatingSystemName() {
        assertEquals(
            expected = "Android",
            actual = platform.osName,
            message = "The OS name should be Android."
        )
    }
}
