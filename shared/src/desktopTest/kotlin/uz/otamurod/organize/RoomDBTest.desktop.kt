package uz.otamurod.organize

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.util.findAndInstantiateDatabaseImpl
import uz.otamurod.organize.database.AppDatabase

actual fun getInMemoryDataBase(): RoomDatabase.Builder<AppDatabase> {
    return Room.inMemoryDatabaseBuilder(
        findAndInstantiateDatabaseImpl(AppDatabase::class.java)
    )
}