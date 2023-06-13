package com.bangkit.freshgrocie

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.freshgrocie.database.response.ResponseProductItem
import com.bangkit.freshgrocie.databinding.ItemCarouselBinding
import com.bangkit.freshgrocie.databinding.ItemProduct2Binding
import com.bangkit.freshgrocie.databinding.ItemProductBinding
import com.bangkit.freshgrocie.ui.DetailProductActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.carousel.MaskableFrameLayout


class HomeAdapter(private val listproduct: List<ResponseProductItem>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null
    var onItemClick: ((ResponseProductItem) -> Unit)? = null
    fun setOnItemClickCallback(callback: OnItemClickCallback) {
        onItemClickCallback = callback
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val product = listproduct[position]
        if (product != null)
        {
           viewHolder.bind(product)
            viewHolder.itemView.setOnClickListener {
                onItemClick?.invoke(product)

//                Log.e("Berhasil", "Berhasil")
            }
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

    class ViewHolder(binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
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
