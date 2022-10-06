package com.example.retrofithomework.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofithomework.repository.BookRepozitory

class MainViewModelFactory(var repoozitory: BookRepozitory) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repoozitory) as T
    }
}