package com.ridery.test.yerih.feature.usertask.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.ridery.test.yerih.core.data.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel@Inject constructor(
    private val userRepository: UserRepository,
) : ViewModel() {

    var user: String = ""


}