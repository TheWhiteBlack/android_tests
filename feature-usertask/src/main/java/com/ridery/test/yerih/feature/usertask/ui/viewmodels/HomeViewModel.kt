package com.ridery.test.yerih.feature.usertask.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.ridery.test.yerih.core.data.UserRepository
import javax.inject.Inject

class HomeViewModel@Inject constructor(
    private val userRepository: UserRepository,
    var user: String
) : ViewModel() {



}