package com.ridery.test.yerih.core.data

import com.ridery.test.yerih.core.database.UserEntity
import com.ridery.test.yerih.core.domain.UserDomain


fun UserDomain.toEntityDB() = UserEntity(username, password)

