package uz.otamurod.organize.presentation

import kotlinx.coroutines.flow.StateFlow
import uz.otamurod.organize.data.RemindersRepository
import uz.otamurod.organize.domain.Reminder

class RemindersViewModel(
    private val repository: RemindersRepository
) : BaseViewModel() {
    
    val reminders: StateFlow<List<Reminder>> = repository.reminders
    
    fun createReminder(title: String) {
        val trimmed = title.trim()
        if (trimmed.isNotEmpty()) {
            repository.createReminder(title = trimmed)
        }
    }
    
    fun markReminder(id: String, isCompleted: Boolean) {
        repository.markReminder(id = id, isCompleted = isCompleted)
    }
    
    fun deleteReminder(reminder: Reminder) {
        repository.deleteReminder(reminder)
    }
}
