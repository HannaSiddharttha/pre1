package com.example.crazyquiz

import androidx.lifecycle.ViewModel

class GameModel : ViewModel() {

    private var questionBank = listOf(
        Question(R.string.question_text_1, true),
        Question(R.string.question_text_2, false),
        Question(R.string.question_text_3, true),
        Question(R.string.question_text_4, false),
        Question(R.string.question_text_5, false) ,
        Question(R.string.question_text_6, true),
        Question(R.string.question_text_7, false),
        Question(R.string.question_text_8, true),
        Question(R.string.question_text_9, false),
        Question(R.string.question_text_10, false),
        Question(R.string.question_text_11, true),
        Question(R.string.question_text_12, false),
        Question(R.string.question_text_13, true),
        Question(R.string.question_text_14, false),
        Question(R.string.question_text_15, false) ,
        Question(R.string.question_text_16, true),
        Question(R.string.question_text_17, false),
        Question(R.string.question_text_18, true),
        Question(R.string.question_text_19, false),
        Question(R.string.question_text_20, false),
        Question(R.string.question_text_21, false),
        Question(R.string.question_text_22, true),
        Question(R.string.question_text_23, false),
        Question(R.string.question_text_24, true),
        Question(R.string.question_text_25, false),
        Question(R.string.question_text_26, false) ,
        Question(R.string.question_text_27, true),
        Question(R.string.question_text_28, false),
        Question(R.string.question_text_29, true),
        Question(R.string.question_text_30, false),
        Question(R.string.question_text_31, false),
        Question(R.string.question_text_32, false),
        Question(R.string.question_text_33, true),
        Question(R.string.question_text_34, false),
        Question(R.string.question_text_35, true),
        Question(R.string.question_text_36, false),
        Question(R.string.question_text_37, false) ,
        Question(R.string.question_text_38, true),
        Question(R.string.question_text_39, false),
        Question(R.string.question_text_40, true),
        Question(R.string.question_text_41, false),
        Question(R.string.question_text_42, false) ,
        Question(R.string.question_text_43, true),
        Question(R.string.question_text_44, false),
        Question(R.string.question_text_45, true),
        Question(R.string.question_text_46, false),
        Question(R.string.question_text_47, false) ,
        Question(R.string.question_text_48, true),
        Question(R.string.question_text_49, false),
        Question(R.string.question_text_50, true),
        Question(R.string.question_text_51, false),
        Question(R.string.question_text_52, false),
        Question(R.string.question_text_53, true),
        Question(R.string.question_text_54, false),
        Question(R.string.question_text_55, true),
        Question(R.string.question_text_56, false),
        Question(R.string.question_text_57, false),
        Question(R.string.question_text_58, true),
        Question(R.string.question_text_59, false),
        Question(R.string.question_text_60, false),


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