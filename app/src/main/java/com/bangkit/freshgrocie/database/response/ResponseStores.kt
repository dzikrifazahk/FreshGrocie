package com.bangkit.freshgrocie.database.response

import com.google.gson.annotations.SerializedName

data class ResponseStores(

	@field:SerializedName("ResponseStores")
	val responseStores: List<ResponseStoresItem>? = null
)

data class Marker(

	@field:SerializedName("_longitude")
	val longitude: Int,

	@field:SerializedName("_latitude")
	val latitude: Int
)

data class ResponseStoresItem(

	@field:SerializedName("store_product")
	val storeProduct: String? = null,

	@field:SerializedName("store_photo")
	val storePhoto: String? = null,

	@field:SerializedName("store_name")
	val storeName: String? = null,

	@field:SerializedName("store_address")
	val storeAddress: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("store_location")
	val storeLocation: String? = null,

	@field:SerializedName("store_description")
	val storeDescription: String? = null,

	@field:SerializedName("marker")
	val marker: Marker,
)
