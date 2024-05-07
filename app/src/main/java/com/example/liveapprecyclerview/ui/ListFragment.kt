package com.example.liveapprecyclerview.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.liveapprecyclerview.MainViewModel
import com.example.liveapprecyclerview.data.DataSource
import com.example.liveapprecyclerview.databinding.FragmentListBinding
import com.example.liveapprecyclerview.ui.adapter.TextAdapter


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private val viewModel : MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //region UI Events werden weitergegeben

        binding.searchET.addTextChangedListener {

            Log.d("textChangedListener", it.toString())
            viewModel.filterContacts(it.toString())
        }

        //endregion


        //region Daten aus dem ViewModel werden observed

        //Dieser Observer aktualisiert unsere RecyclerView
        //Er wird auch ausgeführt wenn die App startet, also "initialisiert"
        //er auch die RecyclerView
        viewModel.filteredContacts.observe(viewLifecycleOwner){
            //Bei jedem Observer solle die erste Zeile ein Log Statement sein
            //Und der Inhalt der LiveData it sollte geloggt werden
            Log.d("filteredContacts", "$it")

            binding.textRV.adapter = TextAdapter(it)


        }

        //endregion


    }


}