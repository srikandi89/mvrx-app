package com.example.mvrx

import android.app.Application
import com.airbnb.mvrx.MvRx
import com.airbnb.mvrx.MvRxViewModelConfigFactory
import com.airbnb.mvrx.mock.MvRxMocks

class MvRxApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        MvRx.viewModelConfigFactory = MvRxViewModelConfigFactory(applicationContext)
        MvRxMocks.install(applicationContext)

    }
}