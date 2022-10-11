package com.example.retrofithomework

import android.app.Application
import com.example.retrofithomework.data.di.DaggerMainComponent
import com.example.retrofithomework.data.di.MainComponent

class App : Application() {
   lateinit var mainComponent: MainComponent
   override fun onCreate() {
      super.onCreate()
      mainComponent = DaggerMainComponent
         .builder()
         .createApplication(this)
         .build()
   }
}

