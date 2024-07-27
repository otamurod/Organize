package uz.otamurod.organize

import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import org.koin.core.module.Module
import org.koin.dsl.module
import uz.otamurod.organize.database.AppDatabase
import uz.otamurod.organize.database.ReminderDao
import uz.otamurod.organize.database.RoomBuilder
import uz.otamurod.organize.database.getRoomDatabase

actual val platformModule: Module = module {
    single<Settings> {
        SharedPreferencesSettings(get())
    }
}

actual val database: Module = module {
    single<AppDatabase> {
        getRoomDatabase(RoomBuilder(get<Context>()).builder())
    }
    
    single<ReminderDao> {
        get<AppDatabase>().getReminderDao()
    }
}