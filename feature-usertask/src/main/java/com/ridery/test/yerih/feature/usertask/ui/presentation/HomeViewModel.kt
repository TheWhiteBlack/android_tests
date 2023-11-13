package com.ridery.test.yerih.feature.usertask.ui.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ridery.test.yerih.core.data.UserRepository
import com.ridery.test.yerih.core.domain.UserDomain
import com.ridery.test.yerih.feature.usertask.ui.presentation.HomeViewModel.UiEvent.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel@Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    var user: String = ""
    var userId: Int = 0


    private val _event = Channel<UiEvent>()
    val event = _event.receiveAsFlow()
    sealed interface UiEvent{
        data object SwipeFinish : UiEvent
        data class ToastMsg(val msg: String) : UiEvent
    }


    private suspend fun post(user: String = ""){
        val result = userRepository.post(UserDomain(user))
        if(result.isSuccess)
            _event.send(ToastMsg("Request success: code = ${result.result}"))
        else
            _event.send(ToastMsg("Request error: message = ${result.error!!.message}"))
    }

    fun onSwipe() = viewModelScope.launch {
        post("swiping user")
        _event.send(SwipeFinish)
    }


}