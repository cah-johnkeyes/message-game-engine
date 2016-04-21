package com.cardinalhealth.fuse.service

import com.cardinalhealth.fuse.model.Player
import spock.lang.Specification

class GameServiceSpec extends Specification {

    Player player
    GameService gameService

    def setup() {
        player = new Player(username:  "walter")
        gameService = new GameService()
    }

    def "it requires a player to start a game"() {
        when:
        gameService.startGame(null)

        then:
        IllegalArgumentException ex = thrown()
    }

    def "it starts a game"() {
        when:
        def game = gameService.startGame(player)

        then:
        game != null
        game.playerOne == player
        game.playerTwo == null
        game.id > 0
    }

    def "it gives each game a unique id"() {
        when:
        def game1 = gameService.startGame(player)
        def game2 = gameService.startGame(player)

        then:
        game1.id != game2.id
    }

    def "it retrieves games by their id"() {
        given:
        def game = gameService.startGame(player)

        when:
        def result = gameService.getGame(game.id)

        then:
        result == game
    }

}
