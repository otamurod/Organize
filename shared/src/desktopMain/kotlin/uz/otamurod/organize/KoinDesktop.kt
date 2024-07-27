package uz.otamurod.organize

import com.russhwolf.settings.PreferencesSettings
import com.russhwolf.settings.Settings
import org.koin.core.module.Module
import org.koin.dsl.module
import uz.otamurod.organize.database.AppDatabase
import uz.otamurod.organize.database.ReminderDao
import uz.otamurod.organize.database.RoomBuilder
import uz.otamurod.organize.database.getRoomDatabase
import java.util.prefs.Preferences

actual val platformModule: Module = module {
    single {
        Preferences.userRoot()
    }
    
    single<Settings> {
        PreferencesSettings(get())
    }
}

actual val database: Module = module {
    single<AppDatabase> {
        getRoomDatabase(RoomBuilder().builder())
    }
    
    single<ReminderDao> {
        get<AppDatabase>().getReminderDao()
    }
}