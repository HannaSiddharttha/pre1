package com.example.crazyquiz.db

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class QuizRepository(application: Application) {
    private val usersDao: UsersDao? = AppDatabase.getInstance(application)?.UsersDao()

    fun insert(user: Users) {
        if (usersDao != null) InsertAsyncTask(usersDao).execute(user)
    }

    fun getUsers(): LiveData<List<Users>> {
        return usersDao?.getAll() ?: MutableLiveData<List<Users>>()
    }

    private class InsertAsyncTask(private val usersDao: UsersDao) :
        AsyncTask<Users, Void, Void>() {
        override fun doInBackground(vararg users: Users?): Void? {

            for (user in users) {
                if (user != null) usersDao.insert(user)
            }

            return null
        }
    }

}