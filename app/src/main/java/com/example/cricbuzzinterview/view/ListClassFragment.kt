package com.example.cricbuzzinterview.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.cricbuzzinterview.R
import com.example.cricbuzzinterview.adapter.ListViewAdapter
import com.example.cricbuzzinterview.databinding.FragmentListBinding
import com.example.cricbuzzinterview.listeners.OnAddButtonClick
import com.example.cricbuzzinterview.model.Data
import com.example.cricbuzzinterview.viewmodel.ListViewModel

class ListClassFragment : Fragment(), OnAddButtonClick {

    private lateinit var binding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel
    private lateinit var data: Data
    private lateinit var listViewAdapter: ListViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        data = listViewModel.getData()
        listViewAdapter = ListViewAdapter(data, this@ListClassFragment, requireContext())
        binding.recyclerView.apply {
            adapter = listViewAdapter
        }
        bindSearch()
        return binding.root
    }

    private fun bindSearch() {
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                
                return false
            }

        })
    }

    override fun onAddButtonClick(dataItem: Data.DataItem, isAdd: Boolean) {
        if (isAdd)
            ItemsListClass.listOfItems.add(dataItem)
        else {
            val bundle = Bundle()
            bundle.putString("name", dataItem.name)
            bundle.putString("id", dataItem.id)
            Navigation.findNavController(binding.root)
                .navigate(R.id.navigate_to_view_details, bundle)
        }
    }
}