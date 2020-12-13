package com.example.crazyquiz.db

import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.*

@Dao
interface GameDao {

    @Query("Select * from games")
    fun getAll(): LiveData<List<Question>>

    @Query("Select * from games where userId = :userId")
    fun getByUser(userId: Int): Question

    @Query("Select * from games where date = :date")
    fun getByDate(date: Date): Question

    @Update
    fun update(users: Users)

    @Insert
    fun insert(question: Question)
    //fun insert(people: List<Users>)

    @Delete
    fun delete(question: Question)
}