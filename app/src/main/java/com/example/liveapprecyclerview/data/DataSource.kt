package com.example.liveapprecyclerview.data


data class Text(
    val text: String,
    val id: Long = 0,
)


class DataSource {

    fun loadStringList() : List<String>{
        return listOf(
            "ABC",
            "DEF",
            "GHJ",
            "Klabautermann",
            "klabautermann",
            "Klbbautermann",
            "klabautermann2",
            "peter",
            "Hallo-Welt",
            "Das hier ist ein String",
        )
    }

    fun loadIntList() : List<Int>{
        return listOf(
            1,
            -2,
            3,
            -500,
            400,
            -16,
            6,
            -4,
            10
        )
    }
}