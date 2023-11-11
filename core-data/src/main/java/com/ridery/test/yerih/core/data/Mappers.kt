package com.ridery.test.yerih.core.data

import android.os.Parcelable
import com.ridery.test.yerih.core.database.UserEntity
import com.ridery.test.yerih.core.domain.UserDomain

fun UserDomain.toEntityDB() = UserEntity(username, password)
fun UserEntity.toDomain() = UserDomain(username, password)
fun List<UserEntity>.toDomain() = map{ it.toDomain()}

