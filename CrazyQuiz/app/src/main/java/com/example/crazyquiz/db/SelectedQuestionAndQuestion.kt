package com.example.crazyquiz.db

import androidx.room.Embedded
import androidx.room.Relation


data class SelectedQuestionAndQuestion(
    @Embedded val selectedQuestion: SelectedQuestion,
    @Relation(
        entity = Question::class,
        parentColumn = "questionId",
        entityColumn = "preguntaId"
    )
    val question: Question,
){
    fun isAnswered(): Boolean {
        return selectedQuestion.answer != null && selectedQuestion.answer > 0
    }

    fun isCorrect(): Boolean {
        return selectedQuestion.answer == question.correcta
    }
}