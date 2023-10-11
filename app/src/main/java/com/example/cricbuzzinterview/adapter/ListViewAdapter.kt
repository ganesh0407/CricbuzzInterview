package com.example.cricbuzzinterview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cricbuzzinterview.R
import com.example.cricbuzzinterview.databinding.ItemListBinding
import com.example.cricbuzzinterview.listeners.OnAddButtonClick
import com.example.cricbuzzinterview.model.Data
import com.example.cricbuzzinterview.view.ItemsListClass

class ListViewAdapter(
    private val data: Data,
    private val onAddButtonClick: OnAddButtonClick,
    private val context: Context
) : RecyclerView.Adapter<ListViewAdapter.ListViewHolder>() {


    inner class ListViewHolder(private val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(item: Data.DataItem) {
            binding.data = item
            binding.txtAdd.setOnClickListener {
                addItemsToCart(item,true)
                Toast.makeText(context, "Added to cart", Toast.LENGTH_LONG).show()
            }
            binding.parent.setOnClickListener {
                addItemsToCart(item,false)
            }

            ItemsListClass.listOfItems.forEach {
                if (it.id == item.id) binding.txtAdd.visibility = View.GONE
                else binding.txtAdd.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = DataBindingUtil.inflate<ItemListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_list, parent, false
        )
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        data[position].let {
            holder.bindData(it)
        }
    }

    fun addItemsToCart(data: Data.DataItem,isAdd:Boolean) {
        onAddButtonClick.onAddButtonClick(data, isAdd)
    }
}