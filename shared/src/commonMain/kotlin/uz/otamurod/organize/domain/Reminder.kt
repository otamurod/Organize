package uz.otamurod.organize.domain

import uz.otamurod.organize.database.ReminderEntity

data class Reminder(
    val id: String,
    val title: String,
    val isCompleted: Boolean = false
)

fun Reminder.mapToEntity() = ReminderEntity(
    id = id,
    title = title,
    isCompleted = isCompleted
)
