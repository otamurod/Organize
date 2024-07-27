package uz.otamurod.organize.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class RoomBuilder(
    private val appContext: Context
) {
    actual fun builder(): RoomDatabase.Builder<AppDatabase> {
        val appContext = appContext.applicationContext
        val dbFile = appContext.getDatabasePath("reminders.db")
        
        return Room.databaseBuilder<AppDatabase>(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}