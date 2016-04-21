package com.cardinalhealth.fuse.service

import com.cardinalhealth.fuse.domain.Exchange
import com.cardinalhealth.fuse.domain.Game
import com.cardinalhealth.fuse.domain.Message
import com.cardinalhealth.fuse.domain.Player
import com.cardinalhealth.fuse.repository.ExchangeRepository
import com.cardinalhealth.fuse.repository.GameRepository
import com.cardinalhealth.fuse.repository.MessageRepository
import com.cardinalhealth.fuse.repository.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GameService {

    @Autowired
    private GameRepository gameRepository

    @Autowired
    private MessageRepository messageRepository

    @Autowired
    private ExchangeRepository exchangeRepository

    @Autowired
    private PlayerRepository playerRepository

    Game startNewGame(Game game) {
        return gameRepository.save(game)
    }

    Game joinExistingGame(Game game) {
        def existingGame = gameRepository.getOne(game.id)
        existingGame.challenger = game.challenger
        return gameRepository.save(existingGame)
    }

    Game get(Integer id) {
        return gameRepository.findOne(id)
    }

    List<Game> list() {
        return gameRepository.findAll()
    }

    Exchange saveMessage(Game game, Player player, Message message) {
        def exchange = exchangeRepository.findByGameAndIsComplete(game, false)

        message.player = player
        message = messageRepository.save(message)

        if (!exchange) {
            exchange = startNewExchange(game, message)
        }
        else if (exchange.initialMessage && exchange.initialMessage.player != player) {
            exchange = updateExchange(exchange, message)
        }

        if (exchange.isComplete) {
            notifyPlayers(game)
        }

        return exchange
    }

    private void notifyPlayers(Game game) {
        println "notify players"
    }

    private Exchange updateExchange(Exchange exchange, Message message) {
        exchange.responseMessage = message
        return exchangeRepository.save(exchange)
    }

    private Exchange startNewExchange(Game game, Message message) {
        def exchange = new Exchange(game: game, initialMessage: message)
        exchange.isComplete = true
        return exchangeRepository.save(exchange)
    }
}
