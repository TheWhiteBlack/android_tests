package com.example.ridery.presentation.injection.component

import com.example.ridery.presentation.features.login.LoginViewModel
import com.example.ridery.presentation.injection.module.LoginModule
import dagger.Component

@Component( modules = [LoginModule::class])
interface LoginComponent {
    fun inject(viewModel: LoginViewModel)
}