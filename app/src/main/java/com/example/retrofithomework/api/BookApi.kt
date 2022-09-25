package com.example.retrofithomework.api

import com.example.retrofithomework.presentation.adapters.Book
import retrofit2.Response
import retrofit2.http.*


// 2)Создать интерфейс, определяющий возможные HTTP Операции (API)
interface BookApi {
    //  https://spring-boot-mysql-server-part0.herokuapp.com/api/books
    @GET("/api/books")
    suspend fun getBooks(): Response<List<Book>>

    @GET("/api/books")
    suspend fun getBooks1(): List<Book>

    //  https://spring-boot-mysql-server-part0.herokuapp.com/api/books/911
    @GET("/api/books/{id}")
    suspend fun getBook(@Path("id") id: Int): Response<Book?>?

    @POST("/api/books/create")
    suspend fun addBook(@Body book: Book): Response<Book?>?

    @PUT("/api/books/{id}")
    suspend fun updateBook(@Path("id") id: Int, @Body book: Book): Response<Book?>?

    //  https://spring-boot-mysql-server-part0.herokuapp.com/api/books/911
    @DELETE("/api/books/{id}")
    suspend fun deleteBook(@Path("id") id: Long): Response<Book?>?


}