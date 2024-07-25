package uz.otamurod.organize.android

import android.app.Application
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import uz.otamurod.organize.Logger
import uz.otamurod.organize.initKoin
import uz.otamurod.organize.presentation.AboutViewModel
import uz.otamurod.organize.presentation.RemindersViewModel

class OrganizeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Logger.log("OrganizeApp is created successfully")
        initKoin(
            viewModelsModule = module {
                viewModel {
                    RemindersViewModel(get())
                }
                viewModel {
                    AboutViewModel(get())
                }
            }
        )
    }
}