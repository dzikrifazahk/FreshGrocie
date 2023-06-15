package com.bangkit.freshgrocie

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.freshgrocie.database.response.ResponseProductItem
import com.bangkit.freshgrocie.database.response.ResponseStoresItem
import com.bangkit.freshgrocie.databinding.ItemCarouselBinding
import com.bangkit.freshgrocie.databinding.ItemProductBinding
import com.bangkit.freshgrocie.databinding.ItemStoreBinding
import com.bumptech.glide.Glide

class StoreAdapterHome(private val listproduct: List<ResponseStoresItem>) :
    RecyclerView.Adapter<StoreAdapterHome.ViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null
    var onItemClick: ((ResponseStoresItem) -> Unit)? = null
    fun setOnItemClickCallback(callback: OnItemClickCallback) {
        onItemClickCallback = callback
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCarouselBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: StoreAdapterHome.ViewHolder, position: Int) {
        val product = listproduct[position]
        if (product != null) {
            viewHolder.bind(product)
            viewHolder.itemView.setOnClickListener {
                onItemClick?.invoke(product)

//                Log.e("Berhasil", "Berhasil")
            }
        }
    }


    override fun getItemCount() = listproduct.size

    class ViewHolder(binding: ItemCarouselBinding) : RecyclerView.ViewHolder(binding.root) {
        val titleTextView: TextView = binding.titleTextView
        val storeLocation: TextView = binding.titleDescription
        val avatarImageView: ImageView = binding.imageView
        fun bind(item: ResponseStoresItem) {
            titleTextView.text = item.storeName
            storeLocation.text = item.storeLocation
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