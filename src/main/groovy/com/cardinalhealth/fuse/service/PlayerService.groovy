package com.cardinalhealth.fuse.service

import com.cardinalhealth.fuse.domain.Player
import com.cardinalhealth.fuse.repository.PlayerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlayerService {

    @Autowired
    PlayerRepository playerRepository

    Player register(Player player) {
        return playerRepository.save(player)
    }

    Player get(Integer id) {
        return playerRepository.getOne(id)
    }
}
