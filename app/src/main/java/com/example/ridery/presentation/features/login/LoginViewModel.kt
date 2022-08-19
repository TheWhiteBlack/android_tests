package com.example.ridery.presentation.features.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ridery.data.room.entities.User
import com.example.ridery.domain.entities.LoginInput
import com.example.ridery.domain.usecases.LoginUseCase
import com.example.ridery.presentation.injection.component.DaggerLoginComponent
import com.example.ridery.presentation.injection.component.LoginComponent
import com.example.ridery.presentation.injection.module.LoginModule
import java.lang.Exception
import javax.inject.Inject

class LoginViewModel: ViewModel() {

    private val loginComponent: LoginComponent = DaggerLoginComponent
        .builder()
        .loginModule(LoginModule())
        .build()

    init {
        loginComponent.inject(this)
    }

    @Inject
    lateinit var loginUseCase: LoginUseCase

    private val user: MutableLiveData<User> = MutableLiveData()
    private val exception: MutableLiveData<Exception> = MutableLiveData()

    fun login(input: LoginInput){
        loginUseCase.execute({
            onComplete {
                user.value = it
            }
            onError {
                exception.value = it
            }
        }, input)
    }

    fun getUser(): LiveData<User>{
        return user
    }

    fun getException(): LiveData<Exception>{
        return exception
    }

}