package uz.otamurod.organize.android

import android.app.Application
import uz.otamurod.organize.Logger

class OrganizeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Logger.log("OrganizeApp is created successfully")
    }
}