package com.bangkit.freshgrocie.database.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.bangkit.freshgrocie.database.remote.ApiService
import com.bangkit.freshgrocie.database.response.ResponseProductItem
import java.lang.Exception

class ProductRepository(private val service: ApiService) {
    fun getProduct(): LiveData<List<ResponseProductItem>> = liveData{
        try {
            val response = service.getProduct()
            if (response.isSuccessful) {
                val listProduct = response.body()?.toList()
                emit(listProduct!!)
            }
            else{
                emit(listOf())
            }
        }
        catch (e:Exception)
        {
            throw Exception(e.message)
        }

    }
    companion object {
        @Volatile
        private var instance: ProductRepository? = null
        fun getInstance(
            apiService: ApiService,
        ): ProductRepository =
            instance ?: synchronized(this) {
                instance ?: ProductRepository(apiService)
            }.also { instance = it }
    }
}
