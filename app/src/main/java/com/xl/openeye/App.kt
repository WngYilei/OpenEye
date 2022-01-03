package com.xl.openeye

import android.app.Application
import com.xl.openeye.dataclass.Data
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object {
        var data: Data? = null
        private lateinit var application: Application
        fun getApp() = application
    }
}