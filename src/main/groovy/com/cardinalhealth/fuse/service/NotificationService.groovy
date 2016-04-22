package com.cardinalhealth.fuse.service

import com.cardinalhealth.fuse.api.GoogleApi
import com.cardinalhealth.fuse.model.Player
import groovy.json.JsonBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class NotificationService {

    @Autowired
    GoogleApi googleApi

    void sendNotification(List<Player> players, Object message) {
        players.each { sendNotification(it, message) }
    }

    void sendNotification(Player player, Object message) {
        if (player.deviceToken) {
            sendNotification(player.deviceToken, message)
        }
    }

    void sendNotification(String token, Object message) {
        def data = new JsonBuilder(message).toString()
        googleApi.sendGcmMessage([to:token, data:data])
    }
}
