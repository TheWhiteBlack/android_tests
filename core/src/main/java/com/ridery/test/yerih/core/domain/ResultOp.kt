package com.ridery.test.yerih.core.domain

import java.lang.IllegalStateException

data class ResultOp<T>(
    val result: T?,
    val error: Error? = null,
){
    init {
        if(result == null && error == null) {
            throw IllegalStateException("Result must have result or error")
        }
    }

    val isError = error != null
    val isSuccess: Boolean = !isError
}