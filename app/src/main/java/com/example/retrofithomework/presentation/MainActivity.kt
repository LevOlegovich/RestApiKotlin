package com.example.retrofithomework.presentation

import android.app.Application
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofithomework.databinding.ActivityMainBinding
import com.example.retrofithomework.presentation.adapters.BookAdapter
import com.example.retrofithomework.utils.Status

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var bookAdapter: BookAdapter = BookAdapter(mutableListOf())
        binding.rv.adapter = bookAdapter
        binding.rv.layoutManager = LinearLayoutManager(this)

        val mainViewModelFact = MainViewModelFactory(applicationContext as Application)
        viewModel = ViewModelProvider(this, mainViewModelFact).get(MainViewModel::class.java)
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