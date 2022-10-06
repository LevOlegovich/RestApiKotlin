package com.example.retrofithomework

import android.app.Application
import android.content.Context
import com.example.retrofithomework.di.DaggerMainComponent
import com.example.retrofithomework.di.MainComponent

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