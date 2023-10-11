package com.example.cricbuzzinterview.model

class Data : ArrayList<Data.DataItem>(){
    data class DataItem(
        val brand: String,
        val colorway: String,
        val gender: String,
        val id: String,
        val media: Media,
        val name: String,
        val releaseDate: String,
        val retailPrice: Int,
        val shoe: String,
        val styleId: String,
        val title: String,
        val year: Int
    ) {
        data class Media(
            val imageUrl: String,
            val smallImageUrl: String,
            val thumbUrl: String
        )
    }
}