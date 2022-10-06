package com.example.retrofithomework.di

import android.app.Application
import android.content.Context
import com.example.retrofithomework.api.ApiHelper
import com.example.retrofithomework.api.BookApi
import com.example.retrofithomework.db.BookDao
import com.example.retrofithomework.db.DbHelper
import dagger.Module
import dagger.Provides

@Module
class MainModule {
    @Provides
    fun createBookApi(): BookApi {
        return ApiHelper.getBookApi()
    }
    @Provides
    fun createBookDB(application:Application):BookDao{
        return DbHelper.getDatabase(application).getBookDao()
    }
}