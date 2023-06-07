package com.bangkit.freshgrocie.viewmodel

import androidx.lifecycle.ViewModel
import com.bangkit.freshgrocie.database.repository.StoresRepository

class StoreViewModel(private val storeRepository : StoresRepository): ViewModel() {
    fun getStore() = storeRepository.getStores()
}