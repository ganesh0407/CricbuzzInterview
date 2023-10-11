package com.example.cricbuzzinterview.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cricbuzzinterview.R
import com.example.cricbuzzinterview.adapter.CartListAdapter
import com.example.cricbuzzinterview.databinding.FragmentCartBinding
import com.example.cricbuzzinterview.listeners.OnButtonClickListener
import com.example.cricbuzzinterview.model.Data

class CartFragment : Fragment(), OnButtonClickListener {

    private lateinit var binding: FragmentCartBinding
    private lateinit var cartListAdapter: CartListAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        cartListAdapter = CartListAdapter(this@CartFragment)
        binding.recyclerView.apply {
            adapter = cartListAdapter
        }
        binding.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }
        setPriceValue()
        return binding.root
    }

    override fun onButtonClick(id: String) {
        ItemsListClass.listOfItems.removeIf { data: Data.DataItem -> data.id == id }
        cartListAdapter.notifyDataSetChanged()
        setPriceValue()
    }

    private fun setPriceValue() {
        var price = 0
        ItemsListClass.listOfItems.forEach {
            price += it.retailPrice
        }
        binding.txtSubtotal.text = "SubTotal: $" + price.toString()
        binding.txtTotal.text = "Total: $" + (price + 40).toString()
    }
}