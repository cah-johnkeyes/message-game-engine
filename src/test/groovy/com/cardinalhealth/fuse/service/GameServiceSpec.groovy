package com.cardinalhealth.fuse.service

import com.cardinalhealth.fuse.model.Player
import spock.lang.Specification

class GameServiceSpec extends Specification {

    Player playerOne
    Player playerTwo
    GameService gameService

    def setup() {
        playerOne = new Player(username:  "walter")
        playerTwo = new Player(username: "donnie")
        gameService = new GameService()
    }

    def "it starts a game"() {
        when:
        def game = gameService.startGame()

        then:
        game != null
        game.id > 0
    }

    def "it joins a player to the game"() {
        given:
        def game = gameService.startGame()

        when:
        def result = gameService.joinGame(game.id, playerTwo)

        then:
        result.id == game.id
        game.players.size() == 1
        game.players.contains(playerTwo)
    }

    def "it gives each game a unique id"() {
        when:
        def game1 = gameService.startGame()
        def game2 = gameService.startGame()

        then:
        game1.id != game2.id
    }

    def "it retrieves games by their id"() {
        given:
        def game = gameService.startGame()

        when:
        def result = gameService.getGame(game.id)

        then:
        result == game
    }

    def "it tracks a message from a player"() {
        given:
        def game = gameService.startGame()
        game = gameService.joinGame(game.id, playerTwo)
        def message = "you're out of your element!"

        when:
        gameService.saveMessage(game.id, playerOne, message)

        then:
        game.messages[playerOne] == message
    }

    def "it prevents player from sending message until response is in"() {
        given:
        def game = gameService.startGame()
        game = gameService.joinGame(game.id, playerTwo)
        def messageOne = "nice marmot"
        def messageTwo = "obviously, you're not a golfer"

        when:
        gameService.saveMessage(game.id, playerOne, messageOne)
        gameService.saveMessage(game.id, playerOne, messageTwo)

        then:
        IllegalArgumentException exception = thrown()
    }

    def "it notifies players when both messages are received"() {
        given:
        def game = gameService.startGame()
        game = gameService.joinGame(game.id, playerTwo)
        def messageOne = "you're out of your element!"
        def messageTwo = "I am the walrus"

        when:
        gameService.saveMessage(game.id, playerOne, messageOne)
        gameService.saveMessage(game.id, playerTwo, messageTwo)

        then:
        !game.messages[playerOne]
        !game.messages[playerTwo]
        gameService.playersHaveBeenNotified
    }

    def "it finishes a game"() {
        given:
        def game = gameService.startGame()

        when:
        gameService.endGame(game.id)

        then:
        !gameService.getGame(game.id)
    }

}
