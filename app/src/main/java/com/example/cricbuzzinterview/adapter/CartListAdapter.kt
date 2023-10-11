package com.example.cricbuzzinterview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cricbuzzinterview.R
import com.example.cricbuzzinterview.databinding.ItemCartBinding
import com.example.cricbuzzinterview.listeners.OnButtonClickListener
import com.example.cricbuzzinterview.model.Data
import com.example.cricbuzzinterview.view.ItemsListClass

class CartListAdapter(
    private val onButtonClickListener: OnButtonClickListener
) : RecyclerView.Adapter<CartListAdapter.CartListHolder>() {

    inner class CartListHolder(private var binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(item: Data.DataItem) {
            binding.data = item
            binding.txtRemoveButton.setOnClickListener {
                onRemoveButtonClick(item.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartListHolder {
        val binding = DataBindingUtil.inflate<ItemCartBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_cart, parent, false
        )
        return CartListHolder(binding)
    }

    override fun getItemCount(): Int {
        return ItemsListClass.listOfItems.size
    }

    override fun onBindViewHolder(holder: CartListHolder, position: Int) {
        ItemsListClass.listOfItems[position].let {
            holder.bindData(it)
        }
    }

    fun onRemoveButtonClick(id: String) {
        onButtonClickListener.onButtonClick(id)
    }
}