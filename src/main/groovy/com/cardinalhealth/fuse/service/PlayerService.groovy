package com.cardinalhealth.fuse.service

import com.cardinalhealth.fuse.model.Player
import org.springframework.stereotype.Service

@Service
class PlayerService {

    static List<Player> players = []

    def register(Player player) {
        if (!player.username) {
            throw new IllegalArgumentException("Username is Required")
        }

        removeExistingPlayer(player)
        addNewPlayer(player)

        return player
    }

    Player get(String username) {
        return players.find { it.username == username }
    }

    private void removeExistingPlayer(Player player) {
        def existingPlayer = get(player.username)
        if (existingPlayer) {
            players.remove(existingPlayer)
        }
    }

    private boolean addNewPlayer(Player player) {
        players << player
    }
}
