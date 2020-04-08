package com.example.mvrx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvrx.modules.my.UserProfileFragment

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container1, UserProfileFragment.newInstance("90"))
                .commit()
        }
    }
}
