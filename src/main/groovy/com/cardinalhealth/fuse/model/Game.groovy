package com.cardinalhealth.fuse.model

class Game {

    List<Player> players = []
    Integer id
    boolean completed

    Map messages = [:]

    void addMessage(Player player, String message) {
        messages[player.username] = message
    }

    boolean playerHasSentMessage(Player player) {
        messages[player.username]
    }

    boolean allPlayersHaveSentMessage() {
        players.every { messages[it] }
    }

    void clearMessages() {
        messages = [:]
    }
}