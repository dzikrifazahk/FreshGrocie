package com.bangkit.freshgrocie.database.response

data class ResponseCart(
    val product : ResponseProductItem,
    val quantity :Int,
) {
//    constructor() : this(ResponseProductItem(), 1)
}
