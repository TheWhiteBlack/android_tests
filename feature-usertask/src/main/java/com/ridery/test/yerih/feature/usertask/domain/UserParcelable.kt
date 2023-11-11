package com.ridery.test.yerih.feature.usertask.domain

import android.os.Parcelable
import com.ridery.test.yerih.core.domain.UserDomain
import kotlinx.android.parcel.Parcelize


@Parcelize
data class UserParcelable(val user: String = "", val password: String = "") : Parcelable

fun UserDomain.toParcelable() = UserParcelable(username, password)
fun UserParcelable.toDomain() = UserDomain(user, password)