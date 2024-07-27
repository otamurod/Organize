package uz.otamurod.organize.data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.otamurod.organize.LogLevel
import uz.otamurod.organize.Logger
import uz.otamurod.organize.database.ReminderDao
import uz.otamurod.organize.database.mapToDomain
import uz.otamurod.organize.domain.Reminder
import uz.otamurod.organize.domain.UUID
import uz.otamurod.organize.domain.mapToEntity

class RemindersRepository(
    private val reminderDao: ReminderDao
) {
    private val scope = CoroutineScope(Dispatchers.IO)
    
    private val _reminders = MutableStateFlow<List<Reminder>>(emptyList())
    val reminders: StateFlow<List<Reminder>> get() = _reminders
    
    init {
        getReminders()
    }
    
    private fun getReminders() {
        scope.launch {
            reminderDao.getAllReminders().collectLatest { reminders ->
                _reminders.value = reminders.map { it.mapToDomain() }
                Logger.log(
                    message = "Reminders are loaded successfully",
                    tag = "RemindersRepository",
                    level = LogLevel.DEBUG
                )
            }
        }
    }
    
    fun createReminder(title: String) {
        val newReminder = Reminder(
            id = UUID().toString(),
            title = title,
            isCompleted = false
        )
        
        scope.launch {
            reminderDao.upsertReminder(newReminder.mapToEntity())
            Logger.log(
                message = "Reminder is created successfully",
                tag = "RemindersRepository",
                level = LogLevel.DEBUG
            )
        }
    }
    
    fun markReminder(id: String, isCompleted: Boolean) {
        val index = _reminders.value.indexOfFirst { it.id == id }
        if (index != -1) {
            scope.launch {
                reminderDao.upsertReminder(
                    _reminders.value[index].copy(isCompleted = isCompleted).mapToEntity()
                )
                Logger.log(
                    message = "Reminder is marked successfully",
                    tag = "RemindersRepository",
                    level = LogLevel.DEBUG
                )
            }
        }
    }
    
    fun deleteReminder(reminder: Reminder) {
        scope.launch {
            reminderDao.deleteReminder(reminder.mapToEntity())
            Logger.log(
                message = "Reminder is deleted successfully",
                tag = "RemindersRepository",
                level = LogLevel.DEBUG
            )
        }
    }
}
