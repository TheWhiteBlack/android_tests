package com.example.ridery.presentation.features.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.ridery.R
import com.example.ridery.presentation.features.editprofile.EditProfileFragment

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        addFragment()
    }

    private fun addFragment() {
        val fragment = EditProfileFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }
}