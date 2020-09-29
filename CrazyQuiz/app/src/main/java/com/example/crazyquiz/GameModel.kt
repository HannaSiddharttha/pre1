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
        Question(R.string.question_text_1, R.string.p1_respuesta_1, R.string.p1_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, HARRY_POTTER),
        Question(R.string.question_text_2, R.string.p2_respuesta_1, R.string.p2_respuesta_1, R.string.p2_respuesta_2, R.string.p2_respuesta_3, R.string.p2_respuesta_4, HARRY_POTTER),
        Question(R.string.question_text_3,R.string.p3_respuesta_1, R.string.p3_respuesta_1, R.string.p3_respuesta_2, R.string.p3_respuesta_3, R.string.p3_respuesta_4, HARRY_POTTER),
        Question(R.string.question_text_4, R.string.p4_respuesta_1, R.string.p4_respuesta_1, R.string.p4_respuesta_2, R.string.p4_respuesta_3, R.string.p4_respuesta_4, HARRY_POTTER),
        Question(R.string.question_text_5, R.string.p5_respuesta_1, R.string.p5_respuesta_1, R.string.p5_respuesta_2, R.string.p5_respuesta_3, R.string.p5_respuesta_4, HARRY_POTTER) ,
        Question(R.string.question_text_6, R.string.p6_respuesta_1, R.string.p6_respuesta_1, R.string.p6_respuesta_2, R.string.p6_respuesta_3, R.string.p6_respuesta_4, HARRY_POTTER),
        Question(R.string.question_text_7,R.string.p7_respuesta_1, R.string.p7_respuesta_1, R.string.p7_respuesta_2, R.string.p7_respuesta_3, R.string.p7_respuesta_4, HARRY_POTTER),
        Question(R.string.question_text_8, R.string.p8_respuesta_1, R.string.p8_respuesta_1, R.string.p8_respuesta_2, R.string.p8_respuesta_3, R.string.p8_respuesta_4, HARRY_POTTER),
        Question(R.string.question_text_9, R.string.p9_respuesta_1, R.string.p9_respuesta_1, R.string.p9_respuesta_2, R.string.p9_respuesta_3, R.string.p9_respuesta_4, HARRY_POTTER),
        Question(R.string.question_text_10,R.string.p10_respuesta_1, R.string.p10_respuesta_1, R.string.p10_respuesta_2, R.string.p10_respuesta_3, R.string.p10_respuesta_4, HARRY_POTTER),

        Question(R.string.question_text_11, R.string.p11_respuesta_1, R.string.p11_respuesta_1, R.string.p11_respuesta_2, R.string.p11_respuesta_3, R.string.p11_respuesta_4, CATS_REPTILES),
        Question(R.string.question_text_12, R.string.p12_respuesta_1, R.string.p12_respuesta_1, R.string.p12_respuesta_2, R.string.p12_respuesta_3, R.string.p12_respuesta_4, CATS_REPTILES),
        Question(R.string.question_text_13, R.string.p13_respuesta_1, R.string.p13_respuesta_1, R.string.p13_respuesta_2, R.string.p13_respuesta_3, R.string.p13_respuesta_4, CATS_REPTILES),
        Question(R.string.question_text_14, R.string.p14_respuesta_1, R.string.p14_respuesta_1, R.string.p14_respuesta_2, R.string.p14_respuesta_3, R.string.p14_respuesta_4, CATS_REPTILES),
        Question(R.string.question_text_15, R.string.p15_respuesta_1, R.string.p15_respuesta_1, R.string.p15_respuesta_2, R.string.p15_respuesta_3, R.string.p15_respuesta_4, CATS_REPTILES),
        Question(R.string.question_text_16, R.string.p16_respuesta_1, R.string.p16_respuesta_1, R.string.p16_respuesta_2, R.string.p16_respuesta_3, R.string.p16_respuesta_4, CATS_REPTILES),
        Question(R.string.question_text_17, R.string.p17_respuesta_1, R.string.p17_respuesta_1, R.string.p17_respuesta_2, R.string.p17_respuesta_3, R.string.p17_respuesta_4, CATS_REPTILES),
        Question(R.string.question_text_18, R.string.p18_respuesta_1, R.string.p18_respuesta_1, R.string.p18_respuesta_2, R.string.p18_respuesta_3, R.string.p18_respuesta_4, CATS_REPTILES),
        Question(R.string.question_text_19, R.string.p19_respuesta_1, R.string.p19_respuesta_1, R.string.p19_respuesta_2, R.string.p19_respuesta_3, R.string.p19_respuesta_4, CATS_REPTILES),
        Question(R.string.question_text_20, R.string.p20_respuesta_1, R.string.p20_respuesta_1, R.string.p20_respuesta_2, R.string.p20_respuesta_3, R.string.p20_respuesta_4, CATS_REPTILES),

        Question(R.string.question_text_21, R.string.p1_respuesta_1, R.string.p21_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, CULTURA_GENERAL),
        Question(R.string.question_text_22, R.string.p1_respuesta_1, R.string.p22_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, CULTURA_GENERAL),
        Question(R.string.question_text_23, R.string.p1_respuesta_1, R.string.p23_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, CULTURA_GENERAL),
        Question(R.string.question_text_24, R.string.p1_respuesta_1, R.string.p24_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, CULTURA_GENERAL),
        Question(R.string.question_text_25, R.string.p1_respuesta_1, R.string.p25_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, CULTURA_GENERAL),
        Question(R.string.question_text_26, R.string.p1_respuesta_1, R.string.p26_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, CULTURA_GENERAL),
        Question(R.string.question_text_27, R.string.p1_respuesta_1, R.string.p27_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, CULTURA_GENERAL),
        Question(R.string.question_text_28, R.string.p1_respuesta_1, R.string.p28_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, CULTURA_GENERAL),
        Question(R.string.question_text_29, R.string.p1_respuesta_1, R.string.p29_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, CULTURA_GENERAL),
        Question(R.string.question_text_30, R.string.p1_respuesta_1, R.string.p30_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, CULTURA_GENERAL),

        Question(R.string.question_text_31, R.string.p1_respuesta_1, R.string.p31_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, FOOD),
        Question(R.string.question_text_32, R.string.p1_respuesta_1, R.string.p32_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, FOOD),
        Question(R.string.question_text_33, R.string.p1_respuesta_1, R.string.p33_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, FOOD),
        Question(R.string.question_text_34, R.string.p1_respuesta_1, R.string.p34_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, FOOD),
        Question(R.string.question_text_35, R.string.p1_respuesta_1, R.string.p35_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, FOOD),
        Question(R.string.question_text_36, R.string.p1_respuesta_1, R.string.p36_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, FOOD),
        Question(R.string.question_text_37, R.string.p1_respuesta_1, R.string.p37_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, FOOD),
        Question(R.string.question_text_38, R.string.p1_respuesta_1, R.string.p38_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, FOOD),
        Question(R.string.question_text_39, R.string.p1_respuesta_1, R.string.p39_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, FOOD),
        Question(R.string.question_text_40, R.string.p1_respuesta_1, R.string.p40_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, FOOD),

        Question(R.string.question_text_41, R.string.p1_respuesta_1, R.string.p41_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, TERROR),
        Question(R.string.question_text_42, R.string.p1_respuesta_1, R.string.p42_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, TERROR),
        Question(R.string.question_text_43, R.string.p1_respuesta_1, R.string.p43_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, TERROR),
        Question(R.string.question_text_44, R.string.p1_respuesta_1, R.string.p44_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, TERROR),
        Question(R.string.question_text_45, R.string.p1_respuesta_1, R.string.p45_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, TERROR),
        Question(R.string.question_text_46, R.string.p1_respuesta_1, R.string.p46_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, TERROR),
        Question(R.string.question_text_47, R.string.p1_respuesta_1, R.string.p47_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, TERROR),
        Question(R.string.question_text_48, R.string.p1_respuesta_1, R.string.p48_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, TERROR),
        Question(R.string.question_text_49, R.string.p1_respuesta_1, R.string.p49_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, TERROR),
        Question(R.string.question_text_50, R.string.p1_respuesta_1, R.string.p50_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, TERROR),

        Question(R.string.question_text_51, R.string.p1_respuesta_1, R.string.p1_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, ARTE_GEOGRAFIA ),
        Question(R.string.question_text_52, R.string.p1_respuesta_1, R.string.p1_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, ARTE_GEOGRAFIA),
        Question(R.string.question_text_53, R.string.p1_respuesta_1, R.string.p1_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, ARTE_GEOGRAFIA),
        Question(R.string.question_text_54, R.string.p1_respuesta_1, R.string.p1_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, ARTE_GEOGRAFIA),
        Question(R.string.question_text_55, R.string.p1_respuesta_1, R.string.p1_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, ARTE_GEOGRAFIA),
        Question(R.string.question_text_56, R.string.p1_respuesta_1, R.string.p1_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, ARTE_GEOGRAFIA),
        Question(R.string.question_text_57, R.string.p1_respuesta_1, R.string.p1_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, ARTE_GEOGRAFIA),
        Question(R.string.question_text_58, R.string.p1_respuesta_1, R.string.p1_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, ARTE_GEOGRAFIA),
        Question(R.string.question_text_59, R.string.p1_respuesta_1, R.string.p1_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, ARTE_GEOGRAFIA),
        Question(R.string.question_text_60, R.string.p1_respuesta_1, R.string.p1_respuesta_1, R.string.p1_respuesta_2, R.string.p1_respuesta_3, R.string.p1_respuesta_4, ARTE_GEOGRAFIA),


    )

    private var currentIndex = 0

    val currentQuestion: Question
        get() = questionBank[currentIndex]

    fun nextQuestion() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun filterQuestions() {
        // aqui deberia filtrarse la lista de preguntas por la nueva lista basada en los "settings".
    }

    override fun onCleared() {
        super.onCleared()
        //Log.d()
    }
}
