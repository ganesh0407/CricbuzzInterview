package com.example.cricbuzzinterview.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cricbuzzinterview.R
import com.example.cricbuzzinterview.databinding.FragmentViewDetailsBinding
import com.example.cricbuzzinterview.model.Data

class ViewDetailsFragment : Fragment() {

    lateinit var binding: FragmentViewDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_view_details, container, false)
        bindDataSize()
        bindDataColor()
        bindAddButton()
        bindBackButton()
        return binding.root
    }

    private fun bindBackButton(){
        binding.imgBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun bindAddButton() {
        binding.txtTitle.text = arguments?.getString("name")
        ItemsListClass.listOfItems.forEach {
            if (it.id == arguments?.getString("id")) binding.btnAdd.visibility = View.GONE
            else binding.btnAdd.visibility = View.VISIBLE
        }
        binding.btnAdd.setOnClickListener {
            ItemsListClass.listOfItems.add(
                Data.DataItem(
                    arguments?.getString("name")!!,
                    "blue",
                    "Male",
                    arguments?.getString("id")!!,
                    Data.DataItem.Media("", "", ""),
                    arguments?.getString("name")!!,
                    "",
                    199,
                    "yes",
                    "",
                    "",
                    0
                )
            )
            binding.btnAdd.visibility = View.GONE
            Toast.makeText(context, "Added to cart", Toast.LENGTH_LONG).show()
        }
    }

    private fun bindDataColor() {
        binding.txtPrimary.setOnClickListener {
            binding.txtPrimary.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(), R.drawable.baseline_done_24
                )
            )
            binding.txtBlue.setImageDrawable(null)
            binding.txtLightBlue.setImageDrawable(null)
        }
        binding.txtBlue.setOnClickListener {
            binding.txtBlue.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(), R.drawable.baseline_done_24
                )
            )
            binding.txtPrimary.setImageDrawable(null)
            binding.txtLightBlue.setImageDrawable(null)
        }

        binding.txtLightBlue.setOnClickListener {
            binding.txtLightBlue.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(), R.drawable.baseline_done_24
                )
            )
            binding.txtBlue.setImageDrawable(null)
            binding.txtPrimary.setImageDrawable(null)
        }
    }

    private fun bindDataSize() {
        binding.txt7.setOnClickListener {
            binding.txt7.setBackgroundResource(R.drawable.button_bg)
            binding.txt7.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            binding.txt8.setBackgroundResource(R.drawable.unselected)
            binding.txt8.setTextColor(ContextCompat.getColor(requireContext(), R.color.primary))
            binding.txt9.setBackgroundResource(R.drawable.unselected)
            binding.txt9.setTextColor(ContextCompat.getColor(requireContext(), R.color.primary))
        }
        binding.txt8.setOnClickListener {
            binding.txt8.setBackgroundResource(R.drawable.button_bg)
            binding.txt8.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            binding.txt7.setBackgroundResource(R.drawable.unselected)
            binding.txt7.setTextColor(ContextCompat.getColor(requireContext(), R.color.primary))
            binding.txt9.setBackgroundResource(R.drawable.unselected)
            binding.txt9.setTextColor(ContextCompat.getColor(requireContext(), R.color.primary))
        }
        binding.txt9.setOnClickListener {
            binding.txt9.setBackgroundResource(R.drawable.button_bg)
            binding.txt9.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            binding.txt8.setBackgroundResource(R.drawable.unselected)
            binding.txt8.setTextColor(ContextCompat.getColor(requireContext(), R.color.primary))
            binding.txt7.setBackgroundResource(R.drawable.unselected)
            binding.txt7.setTextColor(ContextCompat.getColor(requireContext(), R.color.primary))
        }
    }
}