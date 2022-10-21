package com.example.retrofithomework.presentation.dialogfragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.retrofithomework.domain.Book
import com.example.retrofithomework.databinding.MyDialogFragBinding
import com.example.retrofithomework.data.di.MainComponent
import com.example.retrofithomework.data.di.DaggerViewModelFactory
import com.example.retrofithomework.presentation.mainactivity.MainActivity
import javax.inject.Inject

class MyDialogFragment : DialogFragment() {

    private var _binding: MyDialogFragBinding? = null
    val binding
        get() = _binding!!

    private lateinit var viewModel: MyDialogFragmentViewModel
    private lateinit var mainComponent: MainComponent

    @Inject
    lateinit var daggerViewModelFactory: DaggerViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainComponent = (requireActivity() as MainActivity).mainComponent
        mainComponent.inject(this)
        viewModel = ViewModelProvider(requireActivity(), daggerViewModelFactory).get(
            MyDialogFragmentViewModel::class.java)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        _binding = MyDialogFragBinding.inflate(LayoutInflater.from(requireContext()))

        return AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .setPositiveButton("Add book") { _, _ ->
             //   println(binding.editTextAuthor.toString())
                val book = Book(
                    0L,
                    binding.editTextTitle.text.toString(),
                    binding.editTextAuthor.text.toString(),
                    binding.editTextDescription.text.toString(),
                    binding.editTextPublished.text.toString().toLong()
                )
                viewModel.saveBookInRemouteServer(book)
             //   println(book)

            }
            .create()

    }
}