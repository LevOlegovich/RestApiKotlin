package com.example.retrofithomework.presentation.dialogfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofithomework.domain.Book
import com.example.retrofithomework.data.repository.BookRepozitory
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