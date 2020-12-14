package com.example.crazyquiz.db

import androidx.room.Embedded
import androidx.room.Relation


data class GameWithSelectedQuestions(
    @Embedded var game: Game,
    @Relation(
        entity = SelectedQuestion::class,
        parentColumn = "gameId",
        entityColumn = "gameId"
    )
    var selectedQuestions: List<SelectedQuestionAndQuestion>
)