package com.example.mvrx.modules.my

import android.util.Log
import com.example.mvrx.core.MvRxViewModel
import com.example.mvrx.models.MyState
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class MyViewModel(initialState: MyState) : MvRxViewModel<MyState>(initialState) {

    init {
        selectSubscribe(MyState::temperature) {
            Log.d("MyFragmentState", "Temperature: ${it()}")
        }

        selectSubscribe(MyState::titleWithCount) {
            Log.d("MyFragmentState", "Counter: $it")
        }

        asyncSubscribe(MyState::temperature, onSuccess = { temperature ->
            Log.d("MyFragmentState", "OnSuccess: $temperature")
        }, onFail = { error ->
            Log.d("MyFragmentState", "onFail: $error")
        })
    }

    fun incrementCounter() = setState { copy(count = count + 1) }

    fun fetchTemperature() {
        Observable.just(72).delay(3, TimeUnit.SECONDS).execute {
            copy(temperature = it)
        }
    }
}