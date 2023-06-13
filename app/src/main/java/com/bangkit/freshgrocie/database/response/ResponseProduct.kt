package com.bangkit.freshgrocie.database.response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class ResponseProduct(

	val responseProduct: List<ResponseProductItem>
)

data class ResponseProductItem(
	val id: String?,

	@SerializedName("product_unit_price")
	val productUnitPrice: Int? = null,

	@SerializedName("product_stock")
	val productStock: Int? = null,

	@SerializedName("product_description")
	val productDescription: String? = null,

	@SerializedName("product_name")
	val productName: String? = null,

	@SerializedName("product_cateogry")
	val productCategory: String? = null,

	@SerializedName("product_rating")
	val productRating: Double? = null,

	@SerializedName("product_photo")
	val productPhoto: String?
): Parcelable {
	constructor(parcel: Parcel) : this(
		parcel.readString(),
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readValue(Int::class.java.classLoader) as? Int,
		parcel.readString(),
		parcel.readString(),
		parcel.readString(),
		parcel.readValue(Double::class.java.classLoader) as? Double,
		parcel.readString()
	) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(id)
		parcel.writeValue(productUnitPrice)
		parcel.writeValue(productStock)
		parcel.writeString(productDescription)
		parcel.writeString(productName)
		parcel.writeString(productCategory)
		parcel.writeValue(productRating)
		parcel.writeString(productPhoto)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<ResponseProductItem> {
		override fun createFromParcel(parcel: Parcel): ResponseProductItem {
			return ResponseProductItem(parcel)
		}

		override fun newArray(size: Int): Array<ResponseProductItem?> {
			return arrayOfNulls(size)
		}
	}
}

