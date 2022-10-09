package com.example.retrofithomework.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofithomework.presentation.DaggerViewModelFactory
import com.example.retrofithomework.presentation.MainViewModel
import com.example.retrofithomework.presentation.MyDialogFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @ViewModelKey(MainViewModel::class)
    @IntoMap
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @ViewModelKey(MyDialogFragmentViewModel::class)
    @IntoMap
    abstract fun bindMyDialogFragmentViewModel(viewModel: MyDialogFragmentViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory

}