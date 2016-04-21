package com.cardinalhealth.fuse.model

class Game {
    Player playerOne
    Player playerTwo
    Integer id
    private Map messages = [:]

    void addMessage(Player player, String message) {
        messages[player] = message
    }

    boolean playerHasSentMessage(Player player) {
        messages[player]
    }

    void clearMessages() {
        messages = [:]
    }

}
