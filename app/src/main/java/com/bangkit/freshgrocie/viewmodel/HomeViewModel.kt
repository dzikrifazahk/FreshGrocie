package com.bangkit.freshgrocie.viewmodel

import androidx.lifecycle.ViewModel
import com.bangkit.freshgrocie.database.repository.ProductRepository

class HomeViewModel(private val productRepository: ProductRepository): ViewModel() {
    fun getProduct() = productRepository.getProduct()
}