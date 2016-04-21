package com.cardinalhealth.fuse.service

import com.cardinalhealth.fuse.model.Game
import com.cardinalhealth.fuse.model.Player

class GameService {

    private static int nextGameId = 1
    private static List<Game> games = []

    Game startGame(Player player) {
        if (!player)
            throw new IllegalArgumentException("A Player is Required to Start a Game")

        def game = new Game(id: ++nextGameId)
        game.players << player
        games.add(game)

        return game
    }

    Game getGame(Integer id) {
        return games.find { it.id == id }
    }

    Game joinGame(Integer gameId, Player player) {
        def game = getGame(gameId)
        game.players << player
        return game
    }

    void saveMessage(int gameId, Player player, String message) {
        def game = getGame(gameId)

        if (game.playerHasSentMessage(player)) {
            throw new IllegalArgumentException("Message can not be saved. Waiting for other player.")
        }

        game.addMessage(player, message)

        if (game.allPlayersHaveSentMessage()) {
            notifyPlayers(game)
            game.clearMessages()
        }
    }

    void endGame(int gameId) {
        def game = getGame(gameId)
        games.remove(game)
    }

    private void notifyPlayers(Game game) {
        playersHaveBeenNotified = true
    }

    boolean playersHaveBeenNotified = false
}
