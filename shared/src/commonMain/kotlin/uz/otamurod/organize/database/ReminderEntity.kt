package uz.otamurod.organize.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.otamurod.organize.domain.Reminder

@Entity(tableName = "reminders")
data class ReminderEntity(
    @PrimaryKey(autoGenerate = false) val id: String = "",
    val title: String,
    val isCompleted: Boolean
)

fun ReminderEntity.mapToDomain() = Reminder(
    id = id,
    title = title,
    isCompleted = isCompleted
)