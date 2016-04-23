package com.cardinalhealth.fuse.service

import com.cardinalhealth.fuse.api.GoogleApi
import com.cardinalhealth.fuse.model.Game
import com.cardinalhealth.fuse.model.Player
import groovy.json.JsonBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NotificationService {

    @Autowired
    GoogleApi googleApi

    void sendNotification(List<Player> players, Game game) {
        players.each { sendNotification(it, game) }
    }

    void sendNotification(Player player, Game game) {
        if (player.deviceToken) {
            sendNotification(player.deviceToken, game)
        }
    }

    void sendNotification(String token, Game game) {
        new JsonBuilder(game)
        googleApi.sendGcmMessage([to:token, data:game])
    }
}
