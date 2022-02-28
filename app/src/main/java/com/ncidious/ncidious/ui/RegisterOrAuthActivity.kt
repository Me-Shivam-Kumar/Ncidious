package com.ncidious.ncidious.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ncidious.ncidious.R

class RegisterOrAuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_or_auth)

        val enterInFragment =EnterInFragment()
        supportFragmentManager.beginTransaction().add(R.id.register_or_auth_frameLayout,enterInFragment).commit()

    }
}