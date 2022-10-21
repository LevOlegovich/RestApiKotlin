package com.example.retrofithomework.domain

import com.example.retrofithomework.data.repository.BookRepozitory
import javax.inject.Inject

class AddBooksDbUseCase @Inject constructor(var repozitory: BookRepozitory) {
    suspend fun invoke(books: List<Book>) {
        return repozitory.addBooksDb(books)
    }

}