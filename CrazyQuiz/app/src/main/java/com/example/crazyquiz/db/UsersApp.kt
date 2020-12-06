package com.example.crazyquiz.db

import android.app.Application
import androidx.room.Room

class UsersApp : Application() {
    val room = Room
        .databaseBuilder(this, AppDatabase::class.java, "Users")
        .build()
}