package com.example.mvrx.repository

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

data class User(val userId: String, val name: String)

class UserRepository {
    fun getUser(userId: String) = Observable.just(User(userId, "John Doe")).delay(3, TimeUnit.SECONDS)
}