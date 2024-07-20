package uz.otamurod.organize.data

import uz.otamurod.organize.domain.Reminder
import uz.otamurod.organize.domain.UUID

class RemindersRepository {
    private val _reminders: MutableList<Reminder> = mutableListOf()
    val reminders: List<Reminder>
        get() = _reminders
    
    fun createReminder(title: String) {
        val newReminder = Reminder(
            id = UUID().toString(),
            title = title,
            isCompleted = false
        )
        
        _reminders.add(newReminder)
    }
    
    fun markReminder(id: String, isCompleted: Boolean) {
        val index = _reminders.indexOfFirst { it.id == id }
        if (index != -1) {
            _reminders[index] = _reminders[index].copy(isCompleted = isCompleted)
        }
    }
}