package uz.otamurod.organize

import androidx.room.Room
import androidx.room.RoomDatabase
import uz.otamurod.organize.database.AppDatabase

actual fun getInMemoryDataBase(): RoomDatabase.Builder<AppDatabase> {
    return Room.inMemoryDatabaseBuilder { AppDatabase::class.instantiateImpl() }
}