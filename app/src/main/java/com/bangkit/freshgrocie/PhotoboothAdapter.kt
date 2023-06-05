package com.bangkit.freshgrocie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.smarteist.autoimageslider.SliderViewAdapter


class PhotoboothAdapter(imageUrl: ArrayList<String>) :
    SliderViewAdapter<PhotoboothAdapter.SliderViewHolder>() {
    var sliderList: ArrayList<String> = imageUrl


    override fun getCount(): Int {
        return sliderList.size
    }


    override fun onCreateViewHolder(parent: ViewGroup?): PhotoboothAdapter.SliderViewHolder {
        val inflate: View =
            LayoutInflater.from(parent!!.context).inflate(R.layout.phobooth_layout, null)
        return SliderViewHolder(inflate)
    }


    override fun onBindViewHolder(viewHolder: PhotoboothAdapter.SliderViewHolder?, position: Int) {

        if (viewHolder != null) {

            Glide.with(viewHolder.itemView).load(sliderList.get(position)).fitCenter()
                .into(viewHolder.imageView)
        }
    }

    class SliderViewHolder(itemView: View?) : SliderViewAdapter.ViewHolder(itemView) {

        var imageView: ImageView = itemView!!.findViewById(R.id.myimage)
    }
}
