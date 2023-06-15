package com.bangkit.freshgrocie.database.response

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("Response")
	val response: List<ResponseItem>
)

//data class Marker(
//
//	@field:SerializedName("_longitude")
//	val longitude: Int,
//
//	@field:SerializedName("_latitude")
//	val latitude: Int
//)

data class ResponseItem(

	@field:SerializedName("store_photo")
	val storePhoto: String,

//	@field:SerializedName("marker")
//	val marker: Marker,

	@field:SerializedName("store_name")
	val storeName: String,

	@field:SerializedName("store_address")
	val storeAddress: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("store_location")
	val storeLocation: String,

	@field:SerializedName("store_description")
	val storeDescription: String,

	@field:SerializedName("store_product")
	val storeProduct: String
)
