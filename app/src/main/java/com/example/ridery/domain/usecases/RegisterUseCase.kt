package com.example.ridery.domain.usecases

import com.example.ridery.data.room.entities.User
import com.example.ridery.domain.repositories.ProfileRepository

class RegisterUseCase(private val profileRepository: ProfileRepository): UseCase<User, User>() {
    override suspend fun executeOnBackground(input: User): User {
        return profileRepository.saveOrUpdate(input)
    }
}