package com.example.retrofithomework.presentation

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.retrofithomework.presentation.adapters.Book
import com.example.retrofithomework.databinding.MyDialogFragBinding

class MyDialogFragment : DialogFragment() {

    private var _binding: MyDialogFragBinding? = null
    val binding
        get() = _binding!!

    private lateinit var viewModel: MyDialogFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MyDialogFragmentViewModel::class.java)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        _binding = MyDialogFragBinding.inflate(LayoutInflater.from(requireContext()))

        return AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .setPositiveButton("Add book") { _, _ ->
                println(binding.editTextAuthor.toString())
                val book = Book(
                    0L,
                    binding.editTextTitle.text.toString(),
                    binding.editTextAuthor.text.toString(),
                    binding.editTextDescription.text.toString(),
                    binding.editTextPublished.text.toString().toLong()
                )
                viewModel.saveBook(book)
                println(book)

            }
            .create()

    }
}