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
    val globalScore: Int
    get() {
        var total : Int = 0
        for (game in games) {
            if(!game.isActive && game.score > 0) {
                total = total + game.score
            }
        }
        return total;
    }

    val lastDate: Date?
    get() {
        if(games.isEmpty()) {
            return null
        }
        return games.last().date
    }

}