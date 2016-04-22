package com.cardinalhealth.fuse.model

class Game {

    List<Player> players = []
    Integer id

    Map messages = [:]

    void addMessage(Player player, String message) {
        messages[player] = message
    }

    boolean playerHasSentMessage(Player player) {
        messages[player]
    }

    boolean allPlayersHaveSentMessage() {
        players.every { messages[it] }
    }

    void clearMessages() {
        messages = [:]
    }
}