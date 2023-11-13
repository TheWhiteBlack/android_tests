package com.ridery.test.yerih.feature.usertask.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ridery.test.yerih.core.data.UserRepository
import com.ridery.test.yerih.core.domain.UserDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    var user: String = ""

    private val _event = Channel<UiEvent>()
    val event = _event.receiveAsFlow()
    sealed interface UiEvent{
        data class NavigateToLogIn(val user: UserDomain) : UiEvent
        data class ToastMsg(val msg: String) : UiEvent
    }
    private fun saveUser(user: UserDomain) = viewModelScope.launch(Dispatchers.IO) { userRepository.add(user) }

    fun checkCredentials(user: String, password: String, confirm: String) = viewModelScope.launch(Dispatchers.IO) {
        if(user.isEmpty()){
            _event.send(UiEvent.ToastMsg("User cannot be empty"))
            return@launch
        }
        if(password != confirm){
            _event.send(UiEvent.ToastMsg("Password must be equals to confirmation password"))
            return@launch
        }
        if(password.length < 8){
            _event.send(UiEvent.ToastMsg("Password must be greater than 7 characters"))
            return@launch
        }
        val newUser = UserDomain(user, password)
        if(userRepository.getUsers().contains(newUser)){
            _event.send(UiEvent.ToastMsg("This user is registered. You can log in."))
            _event.send(UiEvent.NavigateToLogIn(newUser))
            return@launch
        }
        saveUser(newUser)
        _event.send(UiEvent.NavigateToLogIn(newUser))
        _event.send(UiEvent.ToastMsg("User registered! You can log in now!"))
    }
}