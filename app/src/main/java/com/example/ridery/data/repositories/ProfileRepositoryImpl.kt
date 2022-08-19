package com.example.ridery.data.repositories

import com.example.ridery.data.retrofit.RetrofitBase
import com.example.ridery.data.room.entities.User
import com.example.ridery.data.services.ApiService
import com.example.ridery.domain.repositories.ProfileRepository
import com.example.ridery.presentation.App
import retrofit2.create

class ProfileRepositoryImpl : ProfileRepository {
    private val retrofitBase = RetrofitBase.getRetrofitInstance()
    private val apiService = retrofitBase.create<ApiService>()

    override suspend fun saveOrUpdate(input: User): User {
        val db = App.getDbInstance()
        val id: Long
        if(input.id > 0){
            id = input.id
            db.userDao().update(input)
        }else{
            id = db.userDao().insert(input)
        }
        return db.userDao().getUserById(id)
    }

    override suspend fun callApi(): Boolean {
        val result = apiService.post()
        return result.id > 0
    }
}