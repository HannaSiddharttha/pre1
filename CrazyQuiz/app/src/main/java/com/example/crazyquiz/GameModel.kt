package com.example.crazyquiz

class GameModel {

    private var questionBank = listOf(
        Question(R.string.question_text_1, true),
        Question(R.string.question_text_2, false),
        Question(R.string.question_text_3, true),
        Question(R.string.question_text_4, false),
        Question(R.string.question_text_5, false)
    )

    private var currentIndex = 0

    val currentQuestion: Question
        get() = questionBank[currentIndex]

    fun nextQuestion() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

   // override fun onCleared() {
     //   super.onCleared()
        //Log.d()}
}