package com.example.paktai.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paktai.databinding.RecommendItemBinding

class RecommendAddapter (private val items:List<String>,private val image:List<Int>) : RecyclerView.Adapter<RecommendAddapter.RecommendViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendViewHolder {
        return RecommendViewHolder(RecommendItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecommendViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        holder.bind(item,images)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class RecommendViewHolder(private val binding: RecommendItemBinding) : RecyclerView.ViewHolder(binding.root){
        private val imagesView = binding.imageView
        fun bind(item: String, images: Int) {
            binding.CountryNameRecommend.text = item
            imagesView.setImageResource(images)
        }

    }
}