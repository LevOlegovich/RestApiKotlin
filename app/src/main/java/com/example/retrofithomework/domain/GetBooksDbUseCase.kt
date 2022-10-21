package com.example.retrofithomework.domain

import com.example.retrofithomework.data.repository.BookRepozitory
import retrofit2.Response
import javax.inject.Inject

class GetBooksDbUseCase @Inject constructor(var repozitory: BookRepozitory) {
    suspend fun invoke(): List<Book> {
        return repozitory.getBooksDb()
    }

}