package com.bangkit.freshgrocie.database.response

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
	val productName: String,

	@SerializedName("product_cateogry")
	val productCategory: String? = null,

	@SerializedName("product_rating")
	val productRating: Double? = null,

	@SerializedName("product_photo")
	val productPhoto: String
)

