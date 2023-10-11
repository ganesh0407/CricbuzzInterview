package com.example.cricbuzzinterview.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.cricbuzzinterview.R
import com.example.cricbuzzinterview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.home.setOnClickListener {
            findNavController(R.id.nav_host_fragment_container).navigate(R.id.launcher)
        }
        binding.cart.setOnClickListener {
            findNavController(R.id.nav_host_fragment_container).navigate(R.id.cart)
        }
    }
}