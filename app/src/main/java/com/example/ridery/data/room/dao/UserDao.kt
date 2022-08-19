package com.example.ridery.data.room.dao

import androidx.room.*
import com.example.ridery.data.room.entities.User

@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    suspend fun getAll(): List<User>

    @Query("SELECT * FROM User WHERE email = :email AND password = :password")
    suspend fun getUserByCredentials(email: String, password: String): User

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(people: User): Long

    @Update(onConflict = OnConflictStrategy.ABORT)
    fun update(people: User): Int

    @Query("SELECT * FROM User WHERE id = :id")
    suspend fun getUserById(id: Long): User
}