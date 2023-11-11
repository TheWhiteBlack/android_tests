package com.ridery.test.yerih.feature.usertask.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ridery.test.yerih.core.data.UserRepository
import com.ridery.test.yerih.core.domain.UserDomain
import com.ridery.test.yerih.core.log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel@Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    var user: String = ""

    init {
        viewModelScope.launch {
            val result = userRepository.post(UserDomain("test retrofit"))
            log("homeVM: result isSucc = ${result.isSuccess} , value = ${result.result}")
        }
    }


}