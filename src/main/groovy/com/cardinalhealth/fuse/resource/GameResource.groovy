package com.cardinalhealth.fuse.resource

import com.cardinalhealth.fuse.domain.Game
import com.cardinalhealth.fuse.service.GameService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

@RestController
@RequestMapping(value = "/game")
class GameResource {

    @Autowired
    GameService gameService

    @RequestMapping(method = POST)
    Game create() {
        return gameService.startNewGame()
    }

    @RequestMapping(method = GET)
    List<Game> list() {
        return gameService.list()
    }
}
