package com.example.retrofithomework.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofithomework.presentation.adapters.Book
import com.example.retrofithomework.api.ApiHelper
import com.example.retrofithomework.api.BookApi
import com.example.retrofithomework.repository.BookRepozitory
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyDialogFragmentViewModel @Inject constructor(var repozitory: BookRepozitory) : ViewModel() {

    fun saveBook(book: Book) {

        viewModelScope.launch {
//            var bookApi: BookApi = ApiHelper.getBookApi()
            repozitory.addBookApi(book)
        }
    }
}