package com.example.crazyquiz.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.util.*

@Entity(tableName = "games")

data class Game (
    @PrimaryKey(autoGenerate = true)
    val gameId : Int,
    val userId: Int,
    val isActive: Boolean,
    val score: Int,
    val date: Date,
)