package com.example.ridery.presentation.injection.component

import com.example.ridery.presentation.features.register.ProfileViewModel
import com.example.ridery.presentation.injection.module.ProfileModule
import dagger.Component

@Component(modules = [ProfileModule::class])
interface ProfileComponent {
    fun inject(viewModel: ProfileViewModel)
}