package com.cardinalhealth.fuse.controller

import com.cardinalhealth.fuse.model.Game
import com.cardinalhealth.fuse.service.GameService
import com.cardinalhealth.fuse.service.PlayerService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.*

@RestController
@RequestMapping("/game")
class GameController {

    Logger logger = LoggerFactory.getLogger(GameController)

    @Autowired
    private GameService gameService

    @Autowired
    private PlayerService playerService

    @RequestMapping(method = POST)
    Game startGame() {
        return gameService.startGame()
    }

    @RequestMapping(value = "{gameId}/player/{username}", method = POST)
    Game joinGame(@PathVariable Integer gameId, @PathVariable String username) {
        logger.info("POST /game/${gameId}/player/${username}")
        def player = playerService.get(username)
        return gameService.joinGame(gameId, player)
    }

    @RequestMapping(value = "{gameId}/player/{username}/message", method = POST)
    String sendMessage(@PathVariable Integer gameId, @PathVariable String username, @RequestBody String message) {
        logger.info("POST /game/${gameId}/player/${username}/message [$message]")
        def player = playerService.get(username)
        gameService.saveMessage(gameId, player, message)
        return message
    }

    @RequestMapping(value = "{gameId}", method = DELETE)
    void endGame(@PathVariable Integer gameId) {
        logger.info("DELETE /game/${gameId}")
        gameService.endGame(gameId)
    }

    @RequestMapping(value = "{gameId}", method = GET)
    Game getGame(@PathVariable Integer gameId) {
        logger.info("GET /game/${gameId}")
        gameService.getGame(gameId)
    }
}