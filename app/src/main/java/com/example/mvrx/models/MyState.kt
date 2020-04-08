package com.example.mvrx.models

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import kotlin.random.Random

data class MyState(
    val title: String = "Hello World ${Random.nextInt(100)}",
    val count: Int = 0) : MvRxState {
    val titleWithCount = "$title - $count"
}