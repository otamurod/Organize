package uz.otamurod.organize

import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import uz.otamurod.organize.presentation.RemindersViewModel
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

/**
 * All the tests related to [RemindersViewModel]
 * @author Otamurod
 * Date: 22.07.2024
 */

class RemindersViewModelTest : KoinTest {
    
    private val viewModel: RemindersViewModel by inject()
    
    @BeforeTest
    fun setUp() {
        initKoin()
    }
    
    @Test
    fun testCreatingReminder() {
        val title = "New Title"
        viewModel.createReminder(title = title)
        
        val count = viewModel.reminders.count {
            it.title == title
        }
        
        assertTrue(
            actual = count == 1,
            message = "Reminder with title $title was not created"
        )
    }
    
    @AfterTest
    fun tearDown() {
        stopKoin()
    }
}