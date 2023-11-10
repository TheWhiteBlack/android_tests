package com.ridery.test.yerih.feature.usertask.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ridery.test.yerih.core.data.UserRepository
import com.ridery.test.yerih.core.domain.UserDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private fun saveUser(user: UserDomain) = viewModelScope.launch(Dispatchers.IO) { userRepository.add(user) }
}