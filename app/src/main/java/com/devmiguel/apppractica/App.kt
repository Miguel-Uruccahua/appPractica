package com.devmiguel.apppractica

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
open class App : MultiDexApplication(){
    override fun onCreate() {
        super.onCreate()
    }
}