package com.example.liveapprecyclerview.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.liveapprecyclerview.R
import com.example.liveapprecyclerview.databinding.TextItemBinding

class TextAdapter(
    val dataset: List<String>
) : RecyclerView.Adapter<TextAdapter.TextViewHolder>() {


    inner class TextViewHolder(val binding: TextItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val binding = TextItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TextViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.binding.textTV.text = dataset[position]
    }
}