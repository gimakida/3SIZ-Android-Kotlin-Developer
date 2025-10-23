package com.giovannamakida.ludoboardgames.repository

import com.giovannamakida.ludoboardgames.model.BoardGame
import com.giovannamakida.ludoboardgames.model.GamePublisher

fun getAllBoardGames(): List<BoardGame> {
    return listOf(
        BoardGame("Azul", listOf(Asmodee)),
        BoardGame("Ticket To Ride",
            listOf(Asmodee)),
        BoardGame("Quem Foi?",
            listOf(PaperGames)),
    )
}

fun getBoardGamesBy(title: String):
        List<BoardGame> {
    return getAllBoardGames().filter {
        it.title.startsWith(prefix =
            title, ignoreCase = true)
    }
}