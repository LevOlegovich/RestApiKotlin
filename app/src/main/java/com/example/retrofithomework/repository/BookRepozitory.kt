package com.example.retrofithomework.repository

import com.example.retrofithomework.api.BookApi
import com.example.retrofithomework.db.BookDao
import com.example.retrofithomework.presentation.adapters.Book
import retrofit2.Response
import retrofit2.http.*
import javax.inject.Inject

class BookRepozitory @Inject constructor(var bookApi: BookApi, var bookDb: BookDao) {


    suspend fun getBooksApi(): Response<List<Book>> {

        return bookApi.getBooks()
    }


    suspend fun getBooks1Api(): List<Book> {

        return bookApi.getBooks1()
    }


    suspend fun getBookApi(@Path("id") id: Int): Response<Book?>? {
        return bookApi.getBook(id)
    }


    suspend fun addBookApi(@Body book: Book): Response<Book?>? {
        return bookApi.addBook(book)

    }


    suspend fun updateBookApi(@Path("id") id: Int, @Body book: Book): Response<Book?>? {
        return bookApi.updateBook(id, book)

    }


    suspend fun deleteBookApi(@Path("id") id: Long): Response<Book?>? {
        return bookApi.deleteBook(id)
    }


    suspend fun getBooksDb(): List<Book> {
        return bookDb.getBooks()

    }


    suspend fun getBookDb(id: Int): Book {
        return bookDb.getBook(id)
    }


    suspend fun addBooksDb(books: List<Book>) {
        return bookDb.addBooks(books)
    }


    suspend fun updateBookDb(book: Book) {
        return bookDb.updateBook(book)
    }


    suspend fun updateBooksDb(books: List<Book>) {
        return bookDb.updateBooks(books)
    }


    suspend fun deleteBookDb(book: Book) {
        bookDb.deleteBook(book)
    }
}
