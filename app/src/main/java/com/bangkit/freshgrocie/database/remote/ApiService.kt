package com.bangkit.freshgrocie.database.remote

import com.bangkit.freshgrocie.database.response.ResponseProductItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProduct(): Response<List<ResponseProductItem>>
}