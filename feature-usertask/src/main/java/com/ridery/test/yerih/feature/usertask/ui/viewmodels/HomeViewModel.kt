package com.ridery.test.yerih.feature.usertask.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ridery.test.yerih.core.data.UserRepository
import com.ridery.test.yerih.core.domain.UserDomain
import com.ridery.test.yerih.core.log
import com.ridery.test.yerih.feature.usertask.ui.viewmodels.HomeViewModel.UiEvent.*
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


    private val _event = Channel<UiEvent>()
    val event = _event.receiveAsFlow()
    sealed interface UiEvent{
        data class ToastMsg(val msg: String) : UiEvent
    }

    init {
        viewModelScope.launch {
            val result = userRepository.post(UserDomain("test retrofit"))
            if(result.isSuccess)
                _event.send(ToastMsg("Request success: code = ${result.result}"))
            else
                _event.send(ToastMsg("Request error: message = ${result.error!!.message}"))
        }
    }


}