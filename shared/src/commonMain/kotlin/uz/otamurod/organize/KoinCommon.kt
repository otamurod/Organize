package uz.otamurod.organize

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import uz.otamurod.organize.data.RemindersRepository
import uz.otamurod.organize.presentation.AboutViewModel
import uz.otamurod.organize.presentation.RemindersViewModel

object Modules {
    val core = module {
        factory { Platform() }
    }
    
    val repositories = module {
        factory { RemindersRepository() }
    }
    
    val viewModels = module {
        factory { RemindersViewModel(get()) }
        factory { AboutViewModel(get()) }
    }
}

fun initKoin(
    appModule: Module = module { },
    coreModule: Module = Modules.core,
    repositoriesModule: Module = Modules.repositories,
    viewModelsModule: Module = Modules.viewModels,
): KoinApplication = startKoin {
    modules(
        appModule,
        coreModule,
        repositoriesModule,
        viewModelsModule
    )
}