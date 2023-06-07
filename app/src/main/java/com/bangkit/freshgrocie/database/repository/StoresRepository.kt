package com.bangkit.freshgrocie.database.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.bangkit.freshgrocie.database.remote.ApiService
import com.bangkit.freshgrocie.database.response.ResponseStoresItem
import java.lang.Exception

class StoresRepository(private val service: ApiService) {
    fun getStores(): LiveData<List<ResponseStoresItem>> = liveData{
        try {
            val response = service.getStores()
            if (response.isSuccessful)
            {
                val listStore = response.body()?.toList()
                emit(listStore!!)
            }
            else
            {
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
        private var instanceRepository: StoresRepository? = null
        fun getInstance(
            apiService: ApiService,
        ): StoresRepository =
            instanceRepository ?: synchronized(this) {
                instanceRepository ?: StoresRepository(apiService)
            }.also { instanceRepository = it }
    }
}