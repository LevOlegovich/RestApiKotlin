package com.example.retrofithomework.domain

import com.example.retrofithomework.data.repository.BookRepozitory
import retrofit2.Response
import javax.inject.Inject

class GetBooksApiUseCase @Inject constructor(var repozitory: BookRepozitory) {
    suspend  fun invoke(): Response<List<Book>> {
        return repozitory.getBooksApi()
    }

}