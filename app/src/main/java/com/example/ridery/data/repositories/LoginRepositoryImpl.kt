package com.example.ridery.data.repositories

import com.example.ridery.data.room.entities.User
import com.example.ridery.domain.entities.LoginInput
import com.example.ridery.domain.repositories.LoginRepository
import com.example.ridery.presentation.App

class LoginRepositoryImpl: LoginRepository {
    override suspend fun getUser(input: LoginInput): User? {
        val db = App.getDbInstance()
        return db.userDao().getUserByCredentials(input.email, input.password)
    }
}