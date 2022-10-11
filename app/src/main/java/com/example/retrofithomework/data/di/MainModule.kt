package com.example.retrofithomework.data.di

import android.app.Application
import com.example.retrofithomework.data.api.ApiHelper
import com.example.retrofithomework.data.api.BookApi
import com.example.retrofithomework.data.db.BookDao
import com.example.retrofithomework.data.db.DbHelper
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