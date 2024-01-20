package com.example.testlocation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testlocation.databinding.ItemGovernorateBinding


class AdapterGovernorate(
    private var governorates: List<String>,
    private val onItemSelected: (String) -> Unit
) : RecyclerView.Adapter<AdapterGovernorate.ViewHolder>() {

    class ViewHolder(private val binding: ItemGovernorateBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(governorate: String) {
            binding.tvGovernoratePresent.text = governorate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemGovernorateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return governorates.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = governorates[position]
        holder.bind(currentItem)
        holder.itemView.setOnClickListener {
            onItemSelected(currentItem)
        }
    }

    fun updateData(newData: List<String>) {
        governorates = newData
        notifyDataSetChanged()
    }
}
