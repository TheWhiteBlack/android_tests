package com.ridery.test.yerih.core_service

import com.ridery.test.yerih.core_service.models.PostBody
import com.ridery.test.yerih.core_service.models.PostResponse
import com.ridery.test.yerih.core_service.service.RemoteService
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val service: RemoteService
): RemoteDataSource {
    override suspend fun post(body: PostBody): PostResponse = service.post(body)


}