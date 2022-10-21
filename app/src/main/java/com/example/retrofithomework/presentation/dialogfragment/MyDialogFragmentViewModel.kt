package com.example.retrofithomework.presentation.dialogfragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofithomework.domain.Book
import com.example.retrofithomework.data.repository.BookRepozitory
import com.example.retrofithomework.domain.AddBookApiUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyDialogFragmentViewModel @Inject constructor(
    var repozitory: BookRepozitory,
    var addBookApiUseCase: AddBookApiUseCase,
) : ViewModel() {

    fun saveBookInRemouteServer(book: Book) {
        viewModelScope.launch {
            addBookApiUseCase.invoke(book)
        }
    }
}