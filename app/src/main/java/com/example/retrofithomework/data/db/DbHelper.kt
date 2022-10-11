package com.example.retrofithomework.data.db

import android.content.Context
import androidx.room.Room

object DbHelper {
    fun getDatabase(context: Context): BookDatabase {
        return Room.databaseBuilder(context, BookDatabase::class.java, "BookDB").build()
    }
}