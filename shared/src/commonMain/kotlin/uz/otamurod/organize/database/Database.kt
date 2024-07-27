package uz.otamurod.organize.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Database(
    entities = [ReminderEntity::class],
    version = 1,
    /*autoMigrations = [
        AutoMigration(from = 1, to = 2)
    ]*/
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getReminderDao(): ReminderDao
}

fun getRoomDatabase(
    builder: RoomDatabase.Builder<AppDatabase>
): AppDatabase {
    return builder
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class RoomBuilder {
    fun builder(): RoomDatabase.Builder<AppDatabase>
}