package com.example.crazyquiz.db

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class QuizRepository(application: Application) {
    private val usersDao: UsersDao? = AppDatabase.getInstance(application)?.UsersDao()
    private val questionDao: QuestionDao? = AppDatabase.getInstance(application)?.QuestionDao()

    fun insertUser(user: Users) {
        if (usersDao != null) InsertUserAsyncTask(usersDao).execute(user)
    }

    private class InsertUserAsyncTask(private val usersDao: UsersDao) :
        AsyncTask<Users, Void, Void>() {
        override fun doInBackground(vararg users: Users?): Void? {
            for (user in users) {
                if (user != null) usersDao.insert(user)
            }
            return null
        }
    }

    fun updateUser(user: Users) {
        if (usersDao != null) UpdateUserAsyncTask(usersDao).execute(user)
    }

    private class UpdateUserAsyncTask(private val usersDao: UsersDao) :
        AsyncTask<Users, Void, Void>() {
        override fun doInBackground(vararg users: Users?): Void? {
            for (user in users) {
                if (user != null) usersDao.update(user)
            }
            return null
        }
    }



    fun getUserByEmailPassword(email: String, password: String): LiveData<Users> {
        return usersDao?.getByEmailPassword(email, password) ?: MutableLiveData<Users>()
    }

    fun getUsers(): LiveData<List<Users>> {
        return usersDao?.getAll() ?: MutableLiveData<List<Users>>()
    }
}