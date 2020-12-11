
package com.example.crazyquiz.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.crazyquiz.db.Users
import com.example.crazyquiz.db.UsersDao


@Database(
    entities = [Users:: class, Question::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun UsersDao(): UsersDao
    abstract fun QuestionDao(): QuestionDao


    companion object {
        private const val DATABASE_NAME = "quiz_database"
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            INSTANCE ?: synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }
}