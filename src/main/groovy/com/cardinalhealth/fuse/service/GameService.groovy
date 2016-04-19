package com.cardinalhealth.fuse.service

import com.cardinalhealth.fuse.domain.Game
import com.cardinalhealth.fuse.repository.GameRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GameService {

    @Autowired
    GameRepository gameRepository

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
}
