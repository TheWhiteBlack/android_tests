/*
 * Copyright (C) 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ridery.test.yerih.feature.usertask.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.ridery.test.yerih.core.data.UserRepository
import com.ridery.test.yerih.core.domain.UserDomain
import com.ridery.test.yerih.core.log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {


    private val _event = Channel<UiEvent>()
    val event = _event.receiveAsFlow()
    sealed interface UiEvent{
        data class NavigateToHome(val user: UserDomain) : UiEvent
        data class NavigateToSignUp(val user: UserDomain) : UiEvent
        data class ToastMsg(val msg: String) : UiEvent
    }


    fun onSignUpClicked(user: UserDomain) = viewModelScope.launch(Dispatchers.IO) {
        userRepository.getUsers().let{ users ->
            if(users.contains(user)) {
                _event.send(UiEvent.ToastMsg("User registered. You can log in"))
                return@launch
            }
            _event.send(UiEvent.NavigateToSignUp(user))
        }
    }
    fun onLoginClicked(user: UserDomain) = viewModelScope.launch(Dispatchers.IO) {
        with(user){
            username.ifEmpty { _event.send(UiEvent.ToastMsg("Username can't be empty")); return@launch}
            password.ifEmpty { _event.send(UiEvent.ToastMsg("Password can't be empty")); return@launch }
        }
        userRepository.getUsers().find{ user.username == it.username }?.let{
            if(it.password == user.password)
                _event.send(UiEvent.NavigateToHome(it))
            else
                _event.send(UiEvent.ToastMsg("Check your credentials"))
        }?:_event.send(UiEvent.ToastMsg("User no registered"))
    }
}

sealed interface UserTaskUiState {
    object Loading : UserTaskUiState
    data class Error(val throwable: Throwable) : UserTaskUiState
    data class Success(val data: List<String>) : UserTaskUiState
}
