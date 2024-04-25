package com.example.liveapprecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.liveapprecyclerview.adapter.TextAdapter
import com.example.liveapprecyclerview.data.DataSource
import com.example.liveapprecyclerview.data.Text
import com.example.liveapprecyclerview.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datasource = DataSource()

        var zahlenListe = datasource.loadIntList()
        var textListe = datasource.loadStringList()

        //Einzelnen Int umwandeln zu einem String
        val zahl = -5
        val negativ = (zahl <= 0)
        Log.d("zahlenlog", negativ.toString())
//        Log.d("zahlenlog", "Du hast " + zahl.toString() + " Punkte")


        zahlenListe = zahlenListe.filter {
            //Filter Funktion erwartet einen Boolean als Rückgabe
            it <= 100 && it >= -100
        }

//        zahlenListe = zahlenListe.filter {
//            //Filter Funktion erwartet einen Boolean als Rückgabe
//            (-100..100).contains(it)
//        }


        zahlenListe = zahlenListe.sortedByDescending {
            //Wir wollen ein Ergebnis was "comparable"/"vergleichbar" ist.

            it >= 0

        }

        //Umwandeln der gesamten List von List<Int> zu List<String>
        val ergebnis = zahlenListe.map { zahl ->

            if (zahl == 1) {
                "Du hast $zahl Punkt!"
            } else {
                "Du hast $zahl Punkte!"
            }
        }

        val boolean2 = "ABC" > "DEF"
        textListe = textListe.sortedByDescending {
            it
        }

        showStringList(ergebnis)

    }

    fun showStringList(list: List<String>) {
        Log.d("showStringList", "$list")

        val adapter = TextAdapter(list)
        binding.jokesRV.adapter = adapter
    }

}