package com.ridery.test.yerih.core_service.service

import com.google.gson.GsonBuilder
import com.ridery.test.yerih.core_service.models.PostBody
import com.ridery.test.yerih.core_service.models.PostResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.POST

interface RemoteService {

    companion object {
        private const val urlBase = "https://jsonplaceholder.typicode.com/"
        val gson = GsonBuilder().setLenient().create()
        val gsonConverter = GsonConverterFactory.create(gson)
        val interceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        val okHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

        fun buildRetrofit(
            url: String = urlBase,
            client: OkHttpClient = okHttpClient,
            converter: Converter.Factory = gsonConverter,
        ): Retrofit {
            return Retrofit.Builder()
                .baseUrl(url)
                .client(client)
                .addConverterFactory(converter)
                .build()
        }
    }

    @POST("posts")
    suspend fun post(@Body postBody: PostBody): PostResponse
}



