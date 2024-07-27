package uz.otamurod.organize

import androidx.room.RoomDatabase
import uz.otamurod.organize.database.AppDatabase

expect fun getInMemoryDataBase(): RoomDatabase.Builder<AppDatabase>