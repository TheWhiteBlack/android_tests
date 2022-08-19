package com.example.ridery.presentation.utils

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.regex.Pattern

class Utils {
    companion object {
        fun checkSelfPermission(currentActivity: Activity, permission: String?): Boolean {
            return (ContextCompat.checkSelfPermission(
                currentActivity,
                permission!!
            ) == PackageManager.PERMISSION_GRANTED)
        }

        fun requestPermissions(
            currentActivity: Activity, permissions: Array<String?>,
            requestCode: Int
        ) {
            ActivityCompat.requestPermissions(
                currentActivity,
                permissions, requestCode
            )
        }

        fun validateEmail(email: String?): Boolean {
            val pattern = Pattern.compile(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
            )
            val matcher = pattern.matcher(email)
            return matcher.matches()
        }
    }
}
