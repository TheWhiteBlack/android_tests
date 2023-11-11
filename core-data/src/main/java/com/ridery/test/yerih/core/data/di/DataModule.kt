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

package com.ridery.test.yerih.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import com.ridery.test.yerih.core.data.UserRepository
import com.ridery.test.yerih.core.data.UserRepositoryImpl
import com.ridery.test.yerih.core.database.UserEntity
import com.ridery.test.yerih.core.domain.ResultOp
import com.ridery.test.yerih.core.domain.UserDomain
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindsUserTaskRepository(
        userRepository: UserRepositoryImpl
    ): UserRepository
}

class FakeUserRepository @Inject constructor() : UserRepository {
    override suspend fun getUsers(): List<UserDomain> = fakeUserTasks

    override suspend fun add(user: UserDomain) {
        throw NotImplementedError()
    }

    override suspend fun post(user: UserDomain): ResultOp<Int> {
        return ResultOp(200)
    }
}

val fakeUserTasks = listOf(UserDomain())
