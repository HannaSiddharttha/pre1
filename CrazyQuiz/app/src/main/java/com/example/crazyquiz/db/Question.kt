package com.example.crazyquiz.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity

data class Question(
    @PrimaryKey(autoGenerate = true) val preguntaId : Int,
    val Correcta: Int,
    val answer1: Int,
    val answer2: Int,
    val answer3: Int,
    val answer4: Int,
    val Categoria: Int
)