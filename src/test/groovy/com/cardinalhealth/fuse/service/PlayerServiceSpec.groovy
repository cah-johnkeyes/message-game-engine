package com.cardinalhealth.fuse.service

import com.cardinalhealth.fuse.model.Player
import spock.lang.Specification

class PlayerServiceSpec extends Specification {

    PlayerService playerService

    def setup() {
        playerService = new PlayerService()
    }

    def "it requires a username to register"() {
        given:
        def player = new Player()

        when:
        playerService.register(player)

        then:
        IllegalArgumentException ex = thrown()
    }

    def "it registers a new player"() {
        given:
        def player = new Player(username: "the_dude")

        when:
        playerService.register(player)

        then:
        playerService.get(player.username) == player
    }
}
