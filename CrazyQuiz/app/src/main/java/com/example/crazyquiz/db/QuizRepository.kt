package com.example.crazyquiz.db

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

class QuizRepository(application: Application) {
    private val usersDao: UsersDao? = AppDatabase.getInstance(application)?.UsersDao()
    private val questionDao: QuestionDao? = AppDatabase.getInstance(application)?.QuestionDao()
    private val selectedQuestionDao: SelectedQuestionDao? = AppDatabase.getInstance(application)?.SelectedQuestionDao()
    private val gameDao: GameDao? = AppDatabase.getInstance(application)?.GameDao()

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

    fun insertGame(game: Game) {
        if (gameDao != null) InsertGameAsyncTask(gameDao).execute(game)
    }
    private class InsertGameAsyncTask(private val gameDao: GameDao) :
        AsyncTask<Game, Void, Void>() {
        override fun doInBackground(vararg games: Game?): Void? {
            for (game in games) {
                if (game != null) gameDao.insert(game)
            }
            return null
        }
    }

    fun updateGame(game: Game) {
        if (gameDao != null) UpdateGameAsyncTask(gameDao).execute(game)
    }
    private class UpdateGameAsyncTask(private val gameDao: GameDao) :
        AsyncTask<Game, Void, Void>() {
        override fun doInBackground(vararg games: Game?): Void? {
            for (game in games) {
                if (game != null) gameDao.update(game)
            }
            return null
        }
    }

    fun deleteGame(game: Game) {
        if (gameDao != null) DeleteGameAsyncTask(gameDao).execute(game)
    }
    private class DeleteGameAsyncTask(private val gameDao: GameDao) :
        AsyncTask<Game, Void, Void>() {
        override fun doInBackground(vararg games: Game?): Void? {
            for (game in games) {
                if (game != null) gameDao.delete(game)
            }
            return null
        }
    }


    fun insertSelectedQuestion(selectedQuestion: SelectedQuestion) {
        if (selectedQuestionDao != null) InsertSelectedQuestionAsyncTask(selectedQuestionDao).execute(selectedQuestion)
    }
    private class InsertSelectedQuestionAsyncTask(private val selectedQuestionDao: SelectedQuestionDao) :
        AsyncTask<SelectedQuestion, Void, Void>() {
        override fun doInBackground(vararg selectedQuestions: SelectedQuestion?): Void? {
            for (selectedQuestion in selectedQuestions) {
                if (selectedQuestion != null) selectedQuestionDao.insert(selectedQuestion)
            }
            return null
        }
    }

    fun updateSelectedQuestion(selectedQuestion: SelectedQuestion) {
        if (selectedQuestionDao != null) UpdateSelectedQuestionAsyncTask(selectedQuestionDao).execute(selectedQuestion)
    }
    private class UpdateSelectedQuestionAsyncTask(val selectedQuestionDao: SelectedQuestionDao) :
        AsyncTask<SelectedQuestion, Void, Void>() {
        override fun doInBackground(vararg selectedQuestions: SelectedQuestion?): Void? {
            for (selectedQuestion in selectedQuestions) {
                if (selectedQuestion != null) selectedQuestionDao.update(selectedQuestion)
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

    fun getGamesByUser(userId: Int) : LiveData<List<Game>> {
        return gameDao?.getByUser(userId) ?: MutableLiveData<List<Game>>()
    }

    fun getActiveGameByUser(userId: Int) : LiveData<GameWithSelectedQuestions> {
        return gameDao?.getActiveByUser(userId) ?: MutableLiveData<GameWithSelectedQuestions>()
    }

    fun getGamesByDate(date: Date) : LiveData<List<Game>> {
        return gameDao?.getByDate(date) ?: MutableLiveData<List<Game>>()
    }

    fun getAllQuestions() : LiveData<List<Question>> {
        return questionDao?.getAll() ?: MutableLiveData<List<Question>>()
    }
}