package com.bravedroid.cmp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bravedroid.cmp.databinding.ItemVendorBinding

class ConsentRequestAdapter : ListAdapter<String, ConsentRequestAdapter.ViewHolder>(CmpDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemVendorBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.checkBox.text = getItem(position)
    }

    class ViewHolder(binding: ItemVendorBinding) : RecyclerView.ViewHolder(binding.root) {
        val checkBox: AppCompatCheckBox = binding.itemVendor
    }

    private object CmpDiffUtil : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean = oldItem == newItem
    }
}