package com.example.retrofithomework.presentation.mainactivity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofithomework.App
import com.example.retrofithomework.data.api.BookApi
import com.example.retrofithomework.databinding.ActivityMainBinding
import com.example.retrofithomework.data.db.BookDao
import com.example.retrofithomework.data.di.MainComponent
import com.example.retrofithomework.presentation.adapters.BookAdapter
import com.example.retrofithomework.data.repository.BookRepozitory
import com.example.retrofithomework.data.di.DaggerViewModelFactory
import com.example.retrofithomework.presentation.dialogfragment.MyDialogFragment
import com.example.retrofithomework.data.utils.Status
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    lateinit var mainComponent: MainComponent

    @Inject
    lateinit var mainViewModelFactory: DaggerViewModelFactory

    @Inject
    lateinit var bookApi: BookApi

    @Inject
    lateinit var bookDao: BookDao

    @Inject
    lateinit var repository: BookRepozitory


    override fun onCreate(savedInstanceState: Bundle?) {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        mainComponent = (applicationContext as App).mainComponent
        mainComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var bookAdapter: BookAdapter = BookAdapter(mutableListOf())
        binding.rv.adapter = bookAdapter
        binding.rv.layoutManager = LinearLayoutManager(this)

//        val mainViewModelFactory =
//            MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)
        viewModel.books.observe(this) {

            //
            when (it.status) {

                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    binding.rv.visibility = View.VISIBLE
                    bookAdapter.setList(it.data ?: emptyList())
                    println("LLL")
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.rv.visibility = View.INVISIBLE
                }
                Status.ERROR -> {
                    binding.rv.visibility = View.VISIBLE
                    bookAdapter.setList(it.data ?: emptyList())
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()

                }
            }
        }




        binding.btnAddBook.setOnClickListener {
            MyDialogFragment().show(supportFragmentManager, "MyDialogFragment")
        }
        binding.btnRefresh.setOnClickListener {
            viewModel.loadData()
        }

    }
}