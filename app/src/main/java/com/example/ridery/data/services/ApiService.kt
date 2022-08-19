package com.example.ridery.data.services

import com.example.ridery.domain.entities.Result
import retrofit2.http.POST

interface ApiService {
    @POST("posts")
    suspend fun post(): Result
}