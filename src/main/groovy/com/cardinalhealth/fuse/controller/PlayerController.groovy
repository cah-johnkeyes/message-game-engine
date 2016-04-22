package com.cardinalhealth.fuse.controller

import com.cardinalhealth.fuse.model.Player
import com.cardinalhealth.fuse.service.PlayerService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

@RestController
@RequestMapping("/player")
class PlayerController {

    Logger logger = LoggerFactory.getLogger(PlayerController)

    @Autowired
    private PlayerService playerService

    @RequestMapping(method = POST)
    Player register(@RequestBody Player player) {
        logger.info("POST /player")
        return playerService.register(player)
    }

    @RequestMapping(value = "/{username}", method = GET)
    Player get(@PathVariable String username) {
        logger.info("GET /player/${username}")
        return playerService.get(username)
    }
}
