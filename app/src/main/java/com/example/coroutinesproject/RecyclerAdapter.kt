package com.example.coroutinesproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutinesproject.databinding.CardLayoutBinding

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.NameViewHolder>() {
    private var data: MutableList<Pair<String, Long>> = mutableListOf()

    inner class NameViewHolder(val binding: CardLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CardLayoutBinding.inflate(layoutInflater, parent, false)
        return NameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        val (name, number) = data[position]
        holder.binding.name.text = "The name is $name and the delay was $number milliseconds"
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun addData(name: String, number: Long) {
        data.add(Pair(name, number))
        notifyItemInserted(data.size - 1)
    }
}
