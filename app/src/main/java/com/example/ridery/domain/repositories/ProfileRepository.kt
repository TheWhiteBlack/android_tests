package com.example.ridery.domain.repositories

import com.example.ridery.data.room.entities.User

interface ProfileRepository {
    suspend fun saveOrUpdate(input: User): User
    suspend fun callApi(): Boolean
}