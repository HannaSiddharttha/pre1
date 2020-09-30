package com.example.crazyquiz

data class SelectedQuestion (var answer : Int, var question: Question, var answer1: Int, var answer2: Int, var answer3: Int, var answer4: Int) {
    fun isAnswered(): Boolean {
        return answer != null && answer > 0
    }

    fun isCorrect(): Boolean {
        return answer == question.Correcta
    }
}