package com.bangkit.freshgrocie

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.freshgrocie.database.response.ResponseStoresItem
import com.bangkit.freshgrocie.databinding.ItemCarouselBinding
import com.bangkit.freshgrocie.databinding.ItemStoreBinding
import com.bumptech.glide.Glide

class StoreAdapter(private val listproduct: List<ResponseStoresItem>) :
    RecyclerView.Adapter<StoreAdapter.ViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(callback: OnItemClickCallback) {
        onItemClickCallback = callback
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemStoreBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val product = listproduct[position]
        if (product != null) {
            viewHolder.bind(product)
        }
    }

    override fun getItemCount() = listproduct.size

    class ViewHolder(binding: ItemStoreBinding) : RecyclerView.ViewHolder(binding.root) {
        val titleTextView: TextView = binding.titleTextView

        //        val typeUser: TextView = view.findViewById(R.id.tv_item_description)
        val avatarImageView: ImageView = binding.imageView
        fun bind(item: ResponseStoresItem) {
            titleTextView.text = item.storeName
            Glide.with(itemView.context)
                .load(item.storePhoto)
                .override(200, 150)
                .centerCrop()
                .into(avatarImageView)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ResponseStoresItem)
    }
}