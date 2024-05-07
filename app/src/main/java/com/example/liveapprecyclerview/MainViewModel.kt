package com.example.liveapprecyclerview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.liveapprecyclerview.data.DataSource

class MainViewModel : ViewModel() {


    val allContacts: List<String> = DataSource().loadContacts()

    private val _filteredContacs = MutableLiveData<List<String>>(allContacts)
    val filteredContacts: LiveData<List<String>>
        get() = _filteredContacs


    fun filterContacts(searchTerm : String) {

        val newFilteredList = allContacts.filter {
            it.contains(searchTerm)
        }

        _filteredContacs.value = newFilteredList

    }


}