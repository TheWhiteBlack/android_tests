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

package com.ridery.test.yerih.data

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import com.ridery.test.yerih.core.data.UserRepositoryImpl
import com.ridery.test.yerih.core.database.UserEntity
import com.ridery.test.yerih.core.database.UserTaskDao
import com.ridery.test.yerih.core.domain.UserDomain

/**
 * Unit tests for [UserRepositoryImpl].
 */
@OptIn(ExperimentalCoroutinesApi::class) // TODO: Remove when stable
class DefaultUserEntityRepositoryTest {

    @Test
    fun userTasks_newItemSaved_itemIsReturned() = runTest {
        val repository = UserRepositoryImpl(FakeUserTaskDao())

        repository.add(UserDomain("",""))

        assertEquals(repository.userTasks.first().size, 1)
    }

}

private class FakeUserTaskDao : UserTaskDao {

    private val data = mutableListOf<UserEntity>()

    override fun getUserTasks(): Flow<List<UserEntity>> = flow {
        emit(data)
    }

    override suspend fun insertUserTask(item: UserEntity) {
        data.add(0, item)
    }
}
