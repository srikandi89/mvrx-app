package com.example.mvrx

import android.app.Application
import com.airbnb.mvrx.MvRx
import com.airbnb.mvrx.MvRxViewModelConfigFactory
import com.airbnb.mvrx.mock.MvRxMocks
import com.example.mvrx.repository.UserRepository

class MvRxApplication : Application() {

    val userRepository = UserRepository()

    override fun onCreate() {
        super.onCreate()

        MvRx.viewModelConfigFactory = MvRxViewModelConfigFactory(applicationContext)
        MvRxMocks.install(applicationContext)
    }
}