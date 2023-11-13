/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ridery.test.yerih.core.data

import com.google.gson.Gson
import com.ridery.test.yerih.core.database.UserTaskDao
import com.ridery.test.yerih.core.domain.ResultOp
import com.ridery.test.yerih.core.domain.UserDomain
import com.ridery.test.yerih.core_service.RemoteDataSource
import com.ridery.test.yerih.core_service.models.PostBody
import retrofit2.HttpException
import javax.inject.Inject

interface UserRepository {
    suspend fun getUsers(): List<UserDomain>
    suspend fun add(user: UserDomain)

    suspend fun post(user: UserDomain): ResultOp<Int>
}

class UserRepositoryImpl @Inject constructor(
    private val userTaskDao: UserTaskDao,
    private val remoteData: RemoteDataSource,
) : UserRepository {

    override suspend fun getUsers(): List<UserDomain> = userTaskDao.getUsers().toDomain()

    override suspend fun add(user: UserDomain) {
        val entity = user.toEntityDB()
        userTaskDao.getUsers().find{entity.username == it.username}?.let{found ->
            val copy = found.copy(password = entity.password).apply { uid = found.uid }
            userTaskDao.insertUserTask(copy)
        }?:userTaskDao.insertUserTask(entity)
    }
    override suspend fun post(user: UserDomain): ResultOp<Int> {
        return try{
            remoteData.post(PostBody(
                title = user.username,
                userId = 1,
                body = "user registered"
            ))
            ResultOp(200)
        }catch (httpE: HttpException){
            val errorServer = Gson().asError(httpE)
            ResultOp(null, error = errorServer)
        }catch (e: Exception){
            ResultOp(null, Error(e.message))
        }
    }

}
