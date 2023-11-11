package com.ridery.test.yerih.core.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ridery.test.yerih.core.domain.ErrorServer
import retrofit2.HttpException


fun Gson.asError(httpExc: HttpException): Error{
    val errorResponse = fromJson<ErrorServer>(httpExc.response()?.errorBody()!!.charStream(), object: TypeToken<ErrorServer>() {}.type)
    return Error(errorResponse.error)
}
