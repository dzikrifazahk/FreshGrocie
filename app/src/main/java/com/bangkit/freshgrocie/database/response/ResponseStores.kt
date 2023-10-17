package com.bangkit.freshgrocie.database.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ResponseStores(

	@field:SerializedName("ResponseStores")
	val responseStore: List<ResponseStoresItem>
	//val responseStores: List<Marker.ResponseStoresItem>? = null
)

//data class Marker(
//
//	@field:SerializedName("_longitude")
//	val longitude: String? = null,
//
//	@field:SerializedName("_latitude")
//	val latitude: String? = null
//): Parcelable {
//	constructor(parcel: Parcel) : this(
//		parcel.readString() ?: "",
//		parcel.readString() ?: ""
//
//
//	) {
//	}
//
//	override fun writeToParcel(parcel: Parcel, flags: Int) {
//
//		parcel.writeString(latitude)
//		parcel.writeString(longitude)
//
//	}
//
//	override fun describeContents(): Int {
//		return 0
//	}
//
//	companion object CREATOR : Parcelable.Creator<Marker> {
//		override fun createFromParcel(parcel: Parcel): Marker {
//			return Marker(parcel)
//		}
//
//		override fun newArray(size: Int): Array<Marker?> {
//			return arrayOfNulls(size)
//		}
//	}

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

//	@field:SerializedName("marker")
//	val marker: String,
) : Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(storeProduct)
		parcel.writeString(storePhoto)
		parcel.writeString(storeName)
		parcel.writeString(storeAddress)
		parcel.writeString(id)
		parcel.writeString(storeLocation)
		parcel.writeString(storeDescription)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<ResponseStoresItem> {
		override fun createFromParcel(parcel: Parcel): ResponseStoresItem {
			return ResponseStoresItem(parcel)
		}

		override fun newArray(size: Int): Array<ResponseStoresItem?> {
			return arrayOfNulls(size)
		}
	}
}
