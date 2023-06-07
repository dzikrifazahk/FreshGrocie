package com.bangkit.freshgrocie.di

import com.bangkit.freshgrocie.database.remote.ApiConfig
import com.bangkit.freshgrocie.database.remote.ApiService
import com.bangkit.freshgrocie.database.repository.ProductRepository
import com.bangkit.freshgrocie.database.repository.StoresRepository

object Injection {
    fun provideProductRepository() : ProductRepository
    {
        return ProductRepository.getInstance(ApiConfig.getApiService())
    }
    fun providerStoreRepository() : StoresRepository
    {
        return StoresRepository.getInstance(ApiConfig.getApiService())
    }
}