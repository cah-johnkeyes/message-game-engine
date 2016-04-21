package com.cardinalhealth.fuse.resource

import com.cardinalhealth.fuse.domain.Game
import com.cardinalhealth.fuse.service.GameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.*

@RestController
@RequestMapping(value = "/game")
class GameResource {

    @Autowired
    GameService gameService

    @RequestMapping(method = POST)
    Game startNewGame(@RequestBody Game game) {
        return gameService.startNewGame(game)
    }

    @RequestMapping(value = "/{gameId}", method = GET)
    Game get(@PathVariable Integer gameId) {
        return gameService.get(gameId)
    }

    @RequestMapping(value = "/{gameId}", method = PUT)
    Game joinExistingGame(@PathVariable Integer gameId,
                          @RequestBody Game game) {
        return gameService.joinExistingGame(game)
    }

    @RequestMapping(method = GET)
    List<Game> list() {
        return gameService.list()
    }
}
