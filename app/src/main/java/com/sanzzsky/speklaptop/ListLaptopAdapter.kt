package com.sanzzsky.speklaptop

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanzzsky.speklaptop.databinding.ItemLaptopBinding

class ListLaptopAdapter(
    private val listLaptop: ArrayList<Laptop>,
    private val onItemClick: (Laptop) -> Unit
) : RecyclerView.Adapter<ListLaptopAdapter.LaptopViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaptopViewHolder {
        val binding = ItemLaptopBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LaptopViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LaptopViewHolder, position: Int) {
        holder.bind(listLaptop[position])
    }

    override fun getItemCount(): Int = listLaptop.size

    inner class LaptopViewHolder(private val binding: ItemLaptopBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(laptop: Laptop) {
            binding.tvItemName.text = laptop.name
            binding.tvItemDescription.text = laptop.description
            binding.imgItemPhoto.setImageResource(laptop.imageResId)

            binding.root.setOnClickListener {
                onItemClick(laptop)
            }
        }
    }
}
