package com.example.retrofithomework.domain

import com.example.retrofithomework.data.repository.BookRepozitory
import retrofit2.Response
import javax.inject.Inject

class AddBookApiUseCase @Inject constructor(var repozitory: BookRepozitory) {
    suspend fun invoke(book: Book): Response<Book?>? {
        return repozitory.addBookApi(book)
    }

}