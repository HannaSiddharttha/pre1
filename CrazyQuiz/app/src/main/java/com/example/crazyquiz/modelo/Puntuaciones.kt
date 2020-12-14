package com.example.crazyquiz.modelo

import com.example.crazyquiz.db.GameWithSelectedQuestions

data class Puntuaciones (
    val nombre: String,
    val imagen: String,
    val game: GameWithSelectedQuestions
) {
}