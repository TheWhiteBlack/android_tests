package com.example.ridery.domain.repositories

import com.example.ridery.data.room.entities.User
import com.example.ridery.domain.entities.LoginInput

interface LoginRepository {

    suspend fun getUser(input: LoginInput): User?
}