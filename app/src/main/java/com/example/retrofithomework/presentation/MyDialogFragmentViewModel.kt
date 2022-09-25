package com.example.retrofithomework.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofithomework.presentation.adapters.Book
import com.example.retrofithomework.api.ApiHelper
import com.example.retrofithomework.api.BookApi
import kotlinx.coroutines.launch

class MyDialogFragmentViewModel : ViewModel() {

    fun saveBook(book: Book) {

        viewModelScope.launch {
            var bookApi: BookApi = ApiHelper.getBookApi()
            bookApi.addBook(book)
        }
    }
}