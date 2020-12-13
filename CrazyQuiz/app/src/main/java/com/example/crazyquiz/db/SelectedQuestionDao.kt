package com.example.crazyquiz.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface SelectedQuestionDao {

    @Query("Select * from questions")
    fun getAll(): LiveData<List<SelectedQuestion>>


}