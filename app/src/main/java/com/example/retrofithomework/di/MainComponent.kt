package com.example.retrofithomework.di

import android.app.Application
import com.example.retrofithomework.presentation.MainActivity
import com.example.retrofithomework.presentation.MyDialogFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [MainModule::class, ViewModelModule::class])
interface MainComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun createApplication(application: Application): Builder
        fun build(): MainComponent
    }

    fun inject(mainActivity: MainActivity)
    fun inject(myDialogFragment: MyDialogFragment)
}