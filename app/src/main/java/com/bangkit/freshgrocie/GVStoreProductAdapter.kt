package com.bangkit.freshgrocie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bangkit.freshgrocie.viewmodel.GVStoreProduct

internal class GVStoreProductAdapter (
    private val courseList: List<GVStoreProduct>,
    private val context: Context
    ):
    BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var courseTV: TextView
    private lateinit var courseIV: ImageView

    override fun getCount(): Int {
        return courseList.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView

        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (convertView == null) {

            convertView = layoutInflater!!.inflate(R.layout.item_product, null)
        }
        courseIV = convertView!!.findViewById(R.id.imageView)
        courseTV = convertView!!.findViewById(R.id.tvNameHome)
        courseIV.setImageResource(courseList.get(position).courseImg)
        courseTV.setText(courseList.get(position).courseName)
        return convertView
    }
}

