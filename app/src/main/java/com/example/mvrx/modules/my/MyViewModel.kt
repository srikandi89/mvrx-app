package com.example.mvrx.modules.my

import com.example.mvrx.core.MvRxViewModel
import com.example.mvrx.models.MyState
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class MyViewModel(initialState: MyState) : MvRxViewModel<MyState>(initialState) {
    fun incrementCounter() = setState { copy(count = count + 1) }

    fun fetchTemperature() {
        Observable.just(72).delay(3, TimeUnit.SECONDS).execute {
            copy(temperature = it)
        }
    }
}