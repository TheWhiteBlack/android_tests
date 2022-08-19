package com.example.ridery.presentation.injection.module

import com.example.ridery.data.repositories.ProfileRepositoryImpl
import com.example.ridery.domain.repositories.ProfileRepository
import com.example.ridery.domain.usecases.CallApiUseCase
import com.example.ridery.domain.usecases.RegisterUseCase
import dagger.Module
import dagger.Provides

@Module
class ProfileModule {

    @Provides
    fun provideProfileRepository(): ProfileRepository{
        return ProfileRepositoryImpl()
    }

    @Provides
    fun provideRegisterUseCase(profileRepository: ProfileRepository): RegisterUseCase{
        return RegisterUseCase(profileRepository)
    }

    @Provides
    fun provideCallApiUseCase(profileRepository: ProfileRepository): CallApiUseCase{
        return CallApiUseCase(profileRepository)
    }
}