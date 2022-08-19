package com.example.ridery.data.room.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = ["email"], unique = true)])
data class User (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val lastName: String,
    val email: String,
    val password: String
    )