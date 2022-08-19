package com.example.ridery.domain.usecases

import com.example.ridery.domain.repositories.ProfileRepository

class CallApiUseCase(private val profileRepository: ProfileRepository): UseCase<Boolean, UseCase.None>() {
    override suspend fun executeOnBackground(input: None): Boolean {
        return profileRepository.callApi()
    }
}