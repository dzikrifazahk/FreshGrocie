package com.bangkit.freshgrocie.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bangkit.freshgrocie.database.repository.ProductRepository
import com.bangkit.freshgrocie.di.Injection

class HomeViewModelFactory(private val repository: ProductRepository):
    ViewModelProvider.NewInstanceFactory() {
        companion object {
            @Volatile
            private var INSTANCE: HomeViewModelFactory? = null

            @JvmStatic
            fun getInstance(repo: Context): HomeViewModelFactory {
                if (INSTANCE == null) {
                    synchronized(HomeViewModelFactory::class.java) {
                        INSTANCE = HomeViewModelFactory(Injection.provideProductRepository())
                    }
                }
                return INSTANCE as HomeViewModelFactory
            }
        }

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel(repository) as T
            } else if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                return HomeViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
}