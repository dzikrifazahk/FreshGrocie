package com.bangkit.freshgrocie.di

import com.bangkit.freshgrocie.database.remote.ApiConfig
import com.bangkit.freshgrocie.database.remote.ApiService
import com.bangkit.freshgrocie.database.repository.ProductRepository

object Injection {
    fun provideProductRepository() : ProductRepository
    {
        return ProductRepository.getInstance(ApiConfig.getApiService())
    }
}