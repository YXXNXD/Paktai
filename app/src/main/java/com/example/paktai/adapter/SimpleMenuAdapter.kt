package com.example.paktai.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.paktai.databinding.SearchMenuItemBinding

class SimpleMenuAdapter(
    private val menuItemsName: MutableList<String>,
    private val menuImage: MutableList<Int>
) : RecyclerView.Adapter<SimpleMenuAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = SearchMenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = menuItemsName.size

    inner class MenuViewHolder(private val binding: SearchMenuItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                searchCountryName.text = menuItemsName[position]
                menuImage.setImageResource(menuImage[position])
            }
        }
    }
}

private operator fun ImageView.get(position: Int): Int {
    return 0
}
