package com.example.retrofithomework.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

import com.example.retrofithomework.domain.Book

@Database(entities = [Book::class],version=1)
abstract class BookDatabase: RoomDatabase() {
    abstract fun getBookDao():BookDao
}