package com.ridery.test.yerih.core.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface UserTaskDao {
    @Query("SELECT * FROM userentity ORDER BY uid DESC LIMIT 10")
    fun getUsers(): List<UserEntity>

    @Insert
    suspend fun insertUserTask(item: UserEntity)
}


