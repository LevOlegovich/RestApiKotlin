package com.example.retrofithomework.presentation


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofithomework.presentation.adapters.Book
import com.example.retrofithomework.repository.BookRepozitory
import com.example.retrofithomework.utils.Resource
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class MainViewModel(var repozitory: BookRepozitory) : ViewModel() {

    // val db: BookDatabase = DbHelper.getDatabase(application)
    //val dao: BookDao = db.getBookDao()

    private val _books = MutableLiveData<Resource<List<Book>>>()
    val books: LiveData<Resource<List<Book>>>
        get() = _books

    private val exeptionHandler = CoroutineExceptionHandler { _, exeption ->

        viewModelScope.launch {
            val data = repozitory.bookDb.getBooks()
            _books.postValue(Resource.error("Что то пошло не так!", data))
        }


    }


    init {
        loadData()
    }


    fun loadData() {

        viewModelScope.launch(Dispatchers.Main + exeptionHandler) {
            _books.postValue(Resource.loading())
            val response: Response<List<Book>> = repozitory.getBooksApi()

            if (response.isSuccessful) {
                response.body()?.let { repozitory.addBooksDb(it) }
                _books.postValue(Resource.success(response.body()))
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


}