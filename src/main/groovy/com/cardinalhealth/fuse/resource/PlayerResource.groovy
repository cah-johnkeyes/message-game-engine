package com.cardinalhealth.fuse.resource

import com.cardinalhealth.fuse.domain.Exchange
import com.cardinalhealth.fuse.domain.Message
import com.cardinalhealth.fuse.domain.Player
import com.cardinalhealth.fuse.service.GameService
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
    private PlayerService playerService

    @Autowired
    private GameService gameService

    @RequestMapping(method = POST)
    Player create(@RequestBody Player player) {
        return playerService.register(player)
    }

    @RequestMapping(value = "/{id}", method = GET)
    Player get(@PathVariable Integer id) {
        return playerService.get(id)
    }

    @RequestMapping(value = "/{playerId}/game/{gameId}/message", method = POST)
    Exchange sendMessage(@PathVariable Integer playerId,
                         @PathVariable Integer gameId,
                         @RequestBody Message message) {
        def player = playerService.get(playerId)
        def game = gameService.get(gameId)

        return gameService.saveMessage(game, player, message)
    }

    //    @RequestMapping(value = "/{gameId}/exchange/{playerId}", method = POST)
//    Exchange createExchange(@PathVariable Integer gameId, @RequestBody Exchange exchange) {
//        return gameService.startExchange(gameId, exchange)
//    }
//
//    @RequestMapping(value = "/{gameId}/exchange/{exchangeId}", method = GET)
//    Exchange getExchange(@PathVariable Integer gameId, @PathVariable Integer exchangeId) {
//       return gameService.getExchange(exchangeId)
//    }
//
//    @RequestMapping(value = "/{gameId}/exchange/{exchangeId}", method = GET)
//    Exchange updateExchange(@PathVariable Integer gameId, @PathVariable Integer exchangeId, @RequestBody Exchange exchange) {
//        return gameService.updateExchange(exchange)
//    }

}
