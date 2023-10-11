package com.example.cricbuzzinterview.listeners

import com.example.cricbuzzinterview.model.Data

interface OnAddButtonClick {

    fun onAddButtonClick(dataItem: Data.DataItem, isAdd: Boolean)
}