package com.example.mvrx.models

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized

data class MyState(val title: String = "Hello World State") : MvRxState