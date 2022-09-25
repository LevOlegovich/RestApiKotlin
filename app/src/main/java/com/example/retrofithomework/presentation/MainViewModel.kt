package com.example.retrofithomework.presentation


import android.app.Application
import androidx.lifecycle.*
import com.example.retrofithomework.R
import com.example.retrofithomework.api.ApiHelper
import com.example.retrofithomework.db.BookDao
import com.example.retrofithomework.db.BookDatabase
import com.example.retrofithomework.db.DbHelper
import com.example.retrofithomework.presentation.adapters.Book
import com.example.retrofithomework.utils.Resource
import com.example.retrofithomework.utils.Status
import kotlinx.coroutines.*
import retrofit2.Response


class MainViewModel(application: Application) : ViewModel() {

    val db: BookDatabase = DbHelper.getDatabase(application)
    val dao: BookDao = db.getBookDao()

    private val _books = MutableLiveData<Resource<List<Book>>>()
    val books: LiveData<Resource<List<Book>>>
        get() = _books

    private val exeptionHandler = CoroutineExceptionHandler { _, exeption ->
        _books.postValue(Resource.error(application.getString(R.string.Error)))
    }


    init {
        loadData()
    }


    fun loadData() {

        viewModelScope.launch(Dispatchers.Main + exeptionHandler) {
            val bookApi = ApiHelper.getBookApi()
            _books.postValue(Resource.loading())
            val response: Response<List<Book>> = bookApi.getBooks()
            if (response.isSuccessful) {
                response.body()?.let { dao.updateBooks(it) }
                _books.postValue(Resource.success(response.body()))
            } else {
                _books.postValue(Resource.error(response.message()))
               // getBooks()
            }

//           обработка ошибок. первый способ :
//            try {
//                // ожидаем получение результата
//                val bookApi = ApiHelper.getBookApi()
//                val response: Response<List<Book>> = bookApi.getBooks()
//                if (response.isSuccessful) {
//                    response.body()?.let { dao.addBook(it) }
//                    Toast.makeText(getApplication(), "Успешно!", Toast.LENGTH_SHORT).show()
//
//                }
//
//            } catch (e: Exception) {
//                Toast.makeText(getApplication(), "Ошибка!!! ${e.message}", Toast.LENGTH_SHORT)
//                    .show()
//            }
        }
    }

    fun getBooks() {
        viewModelScope.launch {
            _books.value?.data = dao.getBooks()
        }

    }

//    suspend fun getBooks1(): List<Book> {
//        var x: Deferred<List<Book>> = viewModelScope.async {
//            val bookApi = ApiHelper.getBookApi()
//            bookApi.getBooks1()
//        }
//
//        return x.await()
//
//    }


}