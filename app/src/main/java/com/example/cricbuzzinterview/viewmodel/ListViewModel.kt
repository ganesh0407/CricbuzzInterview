package com.example.cricbuzzinterview.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.cricbuzzinterview.model.Data
import com.example.cricbuzzinterview.repo.ListItemRepo

class ListViewModel(application: Application) : AndroidViewModel(application) {
    private var listItemRepo: ListItemRepo = ListItemRepo()

    fun getData(): Data = listItemRepo.getDataFromApiCall()

}