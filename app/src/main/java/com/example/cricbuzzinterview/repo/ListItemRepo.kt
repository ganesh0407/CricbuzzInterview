package com.example.cricbuzzinterview.repo

import com.example.cricbuzzinterview.model.Data

class ListItemRepo {
    var data = Data()
    fun getDataFromApiCall(): Data {
        for (i in 0..100) {
            data.add(
                Data.DataItem(
                    "Nike " + i,
                    "blue",
                    "Male",
                    "3fa85f64-5717-4562-b3fc-2c963f66afa6" + i,
                    Data.DataItem.Media("", "", ""),
                    "Nike " + i,
                    "",
                    199,
                    "yes",
                    "",
                    "",
                    0
                )
            )

        }
        return data
    }

}