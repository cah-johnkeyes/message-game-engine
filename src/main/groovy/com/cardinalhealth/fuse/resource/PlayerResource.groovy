package com.cardinalhealth.fuse.resource

import com.cardinalhealth.fuse.domain.Player
import com.cardinalhealth.fuse.service.PlayerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

@RestController
@RequestMapping(value = "/player")
class PlayerResource {

    @Autowired
    PlayerService playerService

    @RequestMapping(method = POST)
    Player create(@RequestBody Player player) {
        return playerService.register(player)
    }

    @RequestMapping(value = "/{id}", method = GET)
    Player get(@PathVariable Integer id) {
        return playerService.get(id)
    }
}
