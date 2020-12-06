package com.example.crazyquiz.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class Users(
    @PrimaryKey(autoGenerate = true)
    val userId: Int,
    val userName: String,
    val userEmail: String,
    val userPassword: String
    )