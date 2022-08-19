package com.example.ridery.presentation.features.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ridery.data.room.entities.User
import com.example.ridery.domain.usecases.CallApiUseCase
import com.example.ridery.domain.usecases.RegisterUseCase
import com.example.ridery.domain.usecases.UseCase
import com.example.ridery.presentation.injection.component.DaggerProfileComponent
import com.example.ridery.presentation.injection.component.ProfileComponent
import com.example.ridery.presentation.injection.module.ProfileModule
import java.lang.Exception
import javax.inject.Inject

class ProfileViewModel: ViewModel() {

    private val profileComponent: ProfileComponent = DaggerProfileComponent
        .builder()
        .profileModule(ProfileModule())
        .build()

    init {
        profileComponent.inject(this)
    }

    @Inject
    lateinit var registerUseCase: RegisterUseCase

    @Inject
    lateinit var callApiUseCase: CallApiUseCase

    private val user: MutableLiveData<User> = MutableLiveData()
    private val exception: MutableLiveData<Exception> = MutableLiveData()
    private val success: MutableLiveData<Boolean> = MutableLiveData()
    private val httpException: MutableLiveData<Exception> = MutableLiveData()

    fun saveOrUpdate(userInput: User){
        registerUseCase.execute({
            onComplete {
                user.value = it
            }
            onError {
                exception.value = it
            }
        }, userInput)
    }

    fun callApi(){
        callApiUseCase.execute({
            onComplete {
                success.value = it
            }
            onError {
                httpException.value = it
            }
        }, UseCase.None())
    }

    fun getUser(): LiveData<User>{
        return user
    }

    fun getException(): LiveData<Exception>{
        return exception
    }

    fun getSuccess(): LiveData<Boolean>{
        return success
    }

    fun getHttpException(): LiveData<Exception>{
        return httpException
    }
}