package com.bangkit.freshgrocie.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bangkit.freshgrocie.database.repository.StoresRepository
import com.bangkit.freshgrocie.di.Injection

class StoreViewModelFactory(private val repository: StoresRepository):
    ViewModelProvider.NewInstanceFactory()
    {
        companion object {
        @Volatile
        private var INSTANCE: StoreViewModelFactory? = null

        @JvmStatic
        fun getInstance(repo: Context): StoreViewModelFactory {
            if (INSTANCE == null) {
                synchronized(StoreViewModelFactory::class.java) {
                    INSTANCE = StoreViewModelFactory(Injection.providerStoreRepository())
                }
            }
            return INSTANCE as StoreViewModelFactory
        }
    }

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(StoreViewModel::class.java)) {
                return StoreViewModel(repository) as T
            } else if (modelClass.isAssignableFrom(StoreViewModel::class.java)) {
                return StoreViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
