package com.bangkit.freshgrocie.database.remote

import com.bangkit.freshgrocie.database.response.ResponseProductItem
import com.bangkit.freshgrocie.database.response.ResponseStores
import com.bangkit.freshgrocie.database.response.ResponseStoresItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProduct(): Response<List<ResponseProductItem>>

    @GET("stores")
    suspend fun getStores(): Response<List<ResponseStoresItem>>
}