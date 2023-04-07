package com.bravedroid.cmp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bravedroid.cmp.databinding.ItemVendorBinding

class ConsentRequestAdapter :
    ListAdapter<VendorUiModel, ConsentRequestAdapter.ViewHolder>(CmpDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemVendorBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.checkBox.text = item.vendorDescription
        holder.checkBox.isChecked = item.isAccepted
        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            item.isAccepted = isChecked
        }
    }

    class ViewHolder(binding: ItemVendorBinding) : RecyclerView.ViewHolder(binding.root) {
        val checkBox: AppCompatCheckBox = binding.itemVendor
    }

    private object CmpDiffUtil : DiffUtil.ItemCallback<VendorUiModel>() {
        override fun areItemsTheSame(oldItem: VendorUiModel, newItem: VendorUiModel): Boolean =
            oldItem.vendorName == newItem.vendorName

        override fun areContentsTheSame(oldItem: VendorUiModel, newItem: VendorUiModel): Boolean =
            oldItem == newItem
    }
}
