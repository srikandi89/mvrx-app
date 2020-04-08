package com.example.mvrx.modules.my

import com.example.mvrx.core.MvRxViewModel
import com.example.mvrx.models.MyState

class MyViewModel(initialState: MyState) : MvRxViewModel<MyState>(initialState) {
    fun incrementCounter() = setState { copy(count = count + 1) }
}