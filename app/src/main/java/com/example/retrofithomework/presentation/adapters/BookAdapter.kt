package com.example.retrofithomework.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofithomework.databinding.BookItemNewBinding

class BookAdapter(var list1: MutableList<Book>) : RecyclerView.Adapter<BookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding: BookItemNewBinding =
            BookItemNewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        var book = list1[position]
        val number: String = (position + 1).toString()
        holder.binding.tvId.text = book.id.toString()
        holder.binding.tvTitle.text = book.title
        holder.binding.tvAuthor.text = book.author
        holder.binding.tvDescription.text = book.description
        holder.binding.tvPublished.text = book.published.toString()
        holder.binding.itemNumber.text = number

    }

    override fun getItemCount(): Int {
        return list1.size
    }

    fun setList(mutableList: List<Book>) {
        list1.clear()
        list1.addAll(mutableList)
        notifyDataSetChanged()
    }


}