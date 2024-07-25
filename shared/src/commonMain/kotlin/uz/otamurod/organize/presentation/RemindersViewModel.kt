package uz.otamurod.organize.presentation

import uz.otamurod.organize.data.RemindersRepository
import uz.otamurod.organize.domain.Reminder

class RemindersViewModel(
    private val repository: RemindersRepository
) : BaseViewModel() {
    
    internal val reminders: List<Reminder>
        get() = repository.reminders
    
    var onRemindersUpdated: ((List<Reminder>) -> Unit)? = null
        set(value) {
            field = value
            onRemindersUpdated?.invoke(reminders)
        }
    
    fun createReminder(title: String) {
        val trimmed = title.trim()
        if (trimmed.isNotEmpty()) {
            repository.createReminder(title = trimmed)
            onRemindersUpdated?.invoke(reminders)
        }
    }
    
    fun markReminder(id: String, isCompleted: Boolean) {
        repository.markReminder(id = id, isCompleted = isCompleted)
        onRemindersUpdated?.invoke(reminders)
    }
}