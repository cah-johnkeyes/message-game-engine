package com.cardinalhealth.fuse.controller

import com.cardinalhealth.fuse.model.Player
import com.cardinalhealth.fuse.service.PlayerService
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

    @Autowired
    private PlayerService playerService

    @RequestMapping(method = POST)
    Player register(@RequestBody Player player) {
        return playerService.register(player)
    }

    @RequestMapping(value = "/{username}", method = GET)
    Player get(@PathVariable String username) {
        return playerService.get(username)
    }
}
