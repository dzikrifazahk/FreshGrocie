package com.bangkit.freshgrocie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.freshgrocie.database.response.ResponseProductItem
import com.bangkit.freshgrocie.databinding.ItemCarouselBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class HomeAdapter(private val listproduct: List<ResponseProductItem>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(callback: OnItemClickCallback) {
        onItemClickCallback = callback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCarouselBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val product = listproduct[position]
        if (product != null)
        {
           viewHolder.bind(product)
        }
//        viewHolder.titleTextView.text = product.productName
////        viewHolder.typeUser.text = user.type
//        Glide.with(viewHolder.avatarImageView.context)
//            .load(product.productPhoto)
//            .into(viewHolder.avatarImageView)
//
//        // Set click listener
//        viewHolder.itemView.setOnClickListener {
//            onItemClickCallback?.onItemClicked(product)
//        }
    }

    override fun getItemCount() = listproduct.size

    class ViewHolder(binding: ItemCarouselBinding) : RecyclerView.ViewHolder(binding.root) {
        val titleTextView: TextView = binding.titleTextView
//        val typeUser: TextView = view.findViewById(R.id.tv_item_description)
        val avatarImageView: ImageView = binding.imageView
        fun bind(item: ResponseProductItem){
            titleTextView.text = item.productName
            Glide.with(itemView.context)
                .load(item.productPhoto)
                .override(200,150)
                .centerCrop()
                .into(avatarImageView)
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: ResponseProductItem)
    }
}
