package com.example.ridery.domain.usecases

import com.example.ridery.data.room.entities.User
import com.example.ridery.domain.entities.LoginInput
import com.example.ridery.domain.repositories.LoginRepository

class LoginUseCase(private val loginRepository: LoginRepository): UseCase<User?, LoginInput>() {
    override suspend fun executeOnBackground(input: LoginInput): User? {
        return loginRepository.getUser(input)
    }
}