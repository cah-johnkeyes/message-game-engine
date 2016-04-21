package com.cardinalhealth.fuse.service

import com.cardinalhealth.fuse.model.Game
import com.cardinalhealth.fuse.model.Player

class GameService {

    private static int nextGameId = 1
    private static List<Game> games = []

    Game startGame(Player player) {
        if (!player)
            throw new IllegalArgumentException("A Player is Required to Start a Game")

        def game = new Game(id: ++nextGameId, playerOne: player)
        games.add(game)

        return game
    }

    Game getGame(Integer id) {
        return games.find { it.id == id }
    }
}
