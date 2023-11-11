package com.ridery.test.yerih.core_service

import com.ridery.test.yerih.core_service.models.PostBody
import com.ridery.test.yerih.core_service.models.PostResponse

interface RemoteDataSource {

    suspend fun post(body: PostBody): PostResponse
}