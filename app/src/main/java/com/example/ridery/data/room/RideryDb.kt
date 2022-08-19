package com.example.ridery.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ridery.data.room.dao.UserDao
import com.example.ridery.data.room.entities.User

@Database(
    entities = [User::class],
    version = 1
)
abstract class RideryDb: RoomDatabase() {
    abstract fun userDao(): UserDao
}