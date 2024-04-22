package com.example.liveapprecyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.liveapprecyclerview.data.model.Joke
import com.example.liveapprecyclerview.databinding.JokeItemBinding

class JokeAdapter(
    val dataset: List<Joke>
) : RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {


    inner class JokeViewHolder(val binding: JokeItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val binding = JokeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JokeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke = dataset[position]

        //Codeblock der Inhalte der Daten mit dem Layout verknüpft
        holder.binding.jokeTV.text = joke.jokeText
    }
}