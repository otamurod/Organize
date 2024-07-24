package uz.otamurod.organize

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import uz.otamurod.organize.android.ui.root.MainActivity

class AppUITest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    
    @Test
    fun testAboutButtonExistence() {
        composeTestRule
            .onNodeWithContentDescription("aboutButton")
            .assertIsDisplayed()
    }
    
    @Test
    fun testOpeningAndClosingAboutPage() {
        // Perform a click on the about button
        composeTestRule
            .onNodeWithContentDescription("aboutButton")
            .performClick()
        
        // Verify that the About Device screen is displayed
        composeTestRule
            .onNodeWithText("About Device")
            .assertIsDisplayed()
        
        // Perform a click on the up button
        composeTestRule
            .onNodeWithContentDescription("Up Button")
            .performClick()
        
        // Verify that the Reminders screen is displayed
        composeTestRule
            .onNodeWithText("Reminders")
            .assertIsDisplayed()
    }
}