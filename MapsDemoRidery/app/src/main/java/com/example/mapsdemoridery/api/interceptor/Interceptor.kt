package com.example.mapsdemoridery.api.interceptor

import android.content.Context
import android.widget.Toast
import okhttp3.Interceptor
import okhttp3.Response

class Interceptor(val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())
        val code = response.code()

        // Si el código es 200, mostrar un mensaje
        if (code == 200) {
      //      Toast.makeText(context, "La petición fue exitosa", Toast.LENGTH_SHORT).show()
        }
        return response
    }
}
