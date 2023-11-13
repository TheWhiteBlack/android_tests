package com.example.mapsdemoridery.api

import com.example.mapsdemoridery.api.dataclass.Post
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>
}