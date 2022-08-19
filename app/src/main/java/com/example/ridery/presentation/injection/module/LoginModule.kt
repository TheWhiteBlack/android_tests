package com.example.ridery.presentation.injection.module

import com.example.ridery.data.repositories.LoginRepositoryImpl
import com.example.ridery.domain.repositories.LoginRepository
import com.example.ridery.domain.usecases.LoginUseCase
import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    fun provideLoginRepository(): LoginRepository{
        return LoginRepositoryImpl()
    }

    @Provides
    fun provideLoginUseCase(loginRepository: LoginRepository): LoginUseCase{
        return LoginUseCase(loginRepository)
    }
}