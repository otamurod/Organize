import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import ui.about.AboutView
import ui.reminders.RemindersView
import uz.otamurod.organize.presentation.Screen

class AppUITest {
    // Use createComposeRule to create a ComposeRule
    @get:Rule
    val composeTestRule = createComposeRule()
    
    // Initialize the test setup
    @Before
    fun setUp() {
        composeTestRule.setContent {
            // Set the initial screen state to Reminders
            var screenState by remember { mutableStateOf(Screen.Reminders) }
            
            when (screenState) {
                Screen.Reminders ->
                    RemindersView(
                        onAboutButtonClick = { screenState = Screen.AboutDevice }
                    )
                
                Screen.AboutDevice -> AboutView()
            }
        }
    }
    
    // Test cases
    @Test
    fun testAboutButtonExistence() {
        composeTestRule
            .onNodeWithContentDescription("aboutButton")
            .assertIsDisplayed()
    }
    
    // Test cases
    @Test
    fun testOpeningAboutPage() {
        composeTestRule
            .onNodeWithText("Reminders")
            .assertIsDisplayed()
        
        composeTestRule
            .onNodeWithContentDescription("aboutButton")
            .performClick()
        
        composeTestRule.waitForIdle()
        
        composeTestRule
            .onNodeWithContentDescription("aboutView")
            .assertIsDisplayed()
    }
}