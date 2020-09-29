package com.example.crazyquiz

data class SelectedQuestion (val answer : Int, val question: Question, val answer1: Int, val answer2: Int, val answer3: Int, val answer4: Int) {
    fun isAnswered(): Boolean {
        return answer != null && answer > 0
    }

    fun isCorrect(): Boolean {
        return answer == question.Correcta
    }
}