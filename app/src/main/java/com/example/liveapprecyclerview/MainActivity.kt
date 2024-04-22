package com.example.liveapprecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.liveapprecyclerview.adapter.JokeAdapter
import com.example.liveapprecyclerview.data.Datasource
import com.example.liveapprecyclerview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //RecyclerView mit Adapter und Daten verbinden
        val jokeList = Datasource().loadData()
        val adapter = JokeAdapter(jokeList)
        binding.jokesRV.adapter = adapter

//        val joke = "Klopf Klopf..."
//        val jokeId = R.string.joke1
//
//        binding.textView.text = joke
//        binding.textView.setText(jokeId)
    }
}