package com.example.ridery.domain.usecases

import com.example.ridery.data.room.entities.User
import com.example.ridery.presentation.App

class GetUsersUseCase : UseCase<List<User>, UseCase.None>() {
    override suspend fun executeOnBackground(input: None): List<User> {
        val db = App.getDbInstance()
        db.userDao().insert(User(
            0,
            "jose",
            "hernandez",
            "correo@correo.com",
            "123456"
        ))
        val users = db.userDao().getAll()
        return users
    }
}