package com.example.crazyquiz.db

import androidx.room.Embedded
import androidx.room.Relation
import java.util.*

data class UserWithGames(
    @Embedded var user: Users,
    @Relation(
        entity = Game::class,
        parentColumn = "userId",
        entityColumn = "userId"
    )
    var games: List<Game>,
) {
    fun globalScore(): Int {
        var total : Int = 0
        for (game in games) {
            if(!game.isActive && game.score > 0) {
                total = total + game.score
            }
        }
        return total;
    }
    fun lastDate(): Date? {
        if(games.isEmpty()) {
            return null
        }
        return games.last().date
    }
}