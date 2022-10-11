package com.example.retrofithomework.data.di

import android.app.Application
import com.example.retrofithomework.presentation.mainactivity.MainActivity
import com.example.retrofithomework.presentation.dialogfragment.MyDialogFragment
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