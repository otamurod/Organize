package uz.otamurod.organize

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.test.core.app.ApplicationProvider
import uz.otamurod.organize.database.AppDatabase

actual fun getInMemoryDataBase(): RoomDatabase.Builder<AppDatabase> {
    return Room.inMemoryDatabaseBuilder(
        ApplicationProvider.getApplicationContext(),
        AppDatabase::class.java
    )
}