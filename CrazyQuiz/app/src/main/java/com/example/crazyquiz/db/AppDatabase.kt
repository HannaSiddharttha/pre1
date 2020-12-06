
package com.example.crazyquiz.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.crazyquiz.db.Users
import com.example.crazyquiz.db.UsersDao


@Database(

    entities = [Users:: class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun UsersDao(): UsersDao
}