package com.example.crazyquiz

import androidx.lifecycle.ViewModel

class GameModel : ViewModel() {

    //CATEGORIAS

    val HARRY_POTTER = 1
    val CATS_REPTILES = 2
    val FOOD = 3
    val TERROR = 4
    val CULTURA_GENERAL = 5
    val ARTE_GEOGRAFIA = 6


    private var questionBank = listOf(
        Question(R.string.question_text_1, , ),

    )

    private var currentIndex = 0

    val currentQuestion: Question
        get() = questionBank[currentIndex]

    fun nextQuestion() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    override fun onCleared() {
        super.onCleared()
        //Log.d()
    }
}