package com.cardinalhealth.fuse.service

import com.cardinalhealth.fuse.domain.Exchange
import com.cardinalhealth.fuse.domain.Game
import com.cardinalhealth.fuse.domain.Message
import com.cardinalhealth.fuse.repository.ExchangeRepository
import com.cardinalhealth.fuse.repository.GameRepository
import com.cardinalhealth.fuse.repository.MessageRepository
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

    Game startNewGame() {
        def game = new Game()
        return gameRepository.save(game)
    }

    Game get(Integer id) {
        return gameRepository.findOne(id)
    }

    List<Game> list() {
        return gameRepository.findAll()
    }

    Exchange startExchange(Integer id, Message message) {
        def game = get(id)
        def initialMessage = messageRepository.save(message)
        def exchange = new Exchange(game: game, initialMessage: initialMessage)

        return exchangeRepository.save(exchange)
    }
}
