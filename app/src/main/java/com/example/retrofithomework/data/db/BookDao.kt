package com.example.retrofithomework.data.db

import androidx.room.*
import com.example.retrofithomework.domain.Book


@Dao
interface BookDao {
    @Query("SELECT * FROM book")
    suspend fun getBooks(): List<Book>

    @Query("SELECT * FROM book WHERE id=:id")
    suspend fun getBook(id: Int): Book

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addBooks(books: List<Book>)

    @Update
    suspend fun updateBook(book: Book)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateBooks(books: List<Book>)

    @Delete
    suspend fun deleteBook(book: Book)


}