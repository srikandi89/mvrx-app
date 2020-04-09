package com.example.mvrx

import android.app.Application
import com.airbnb.mvrx.MvRx
import com.airbnb.mvrx.MvRxViewModelConfigFactory
import com.airbnb.mvrx.mock.MvRxMocks
import com.example.mvrx.repository.UserRepository
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MvRxModule {
    @Singleton
    @Provides
    fun provideUserRepository() = UserRepository()
}

@Singleton
@Component(modules = [MvRxModule::class])
interface MvRxComponent {
    fun userRepository(): UserRepository
}

class MvRxApplication : Application() {

    val component = DaggerMvRxComponent.create()

    override fun onCreate() {
        super.onCreate()

        MvRx.viewModelConfigFactory = MvRxViewModelConfigFactory(applicationContext)
        MvRxMocks.install(applicationContext)
    }
}