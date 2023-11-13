package com.ridery.test.yerih.core.data

import android.os.Parcelable
import com.ridery.test.yerih.core.database.UserEntity
import com.ridery.test.yerih.core.domain.UserDomain

fun UserDomain.toEntityDB() = UserEntity(username, password, uid)
fun UserEntity.toDomain() = UserDomain(username, password, uid)
fun List<UserEntity>.toDomain() = map{ it.toDomain()}

