package com.example.paktai.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paktai.databinding.SearchMenuItemBinding

class MenuAdapter(
    private val menuItemsName: MutableList<String>,
    private val menuItemsName2: MutableList<String>,
    private val menuItemsGuideName: MutableList<String>,
    private val menuItemsPrice: MutableList<String>,
    private val MenuImage: MutableList<Int>
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = SearchMenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItemsName.size

    inner class MenuViewHolder(private val binding: SearchMenuItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                SearchCountryname.text = menuItemsName[position]
                SearchCountry.text = menuItemsName2[position]
                SearchGuideName.text = menuItemsGuideName[position]
                searchPrice.text = menuItemsPrice[position]
                SearchmenuImage.setImageResource(MenuImage[position])
            }
        }
    }
}