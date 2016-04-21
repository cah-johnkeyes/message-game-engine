package com.cardinalhealth.fuse.repository

import com.cardinalhealth.fuse.domain.Exchange
import com.cardinalhealth.fuse.domain.Game
import org.springframework.data.jpa.repository.JpaRepository

interface ExchangeRepository extends JpaRepository<Exchange, Integer> {

    Exchange findByGameAndIsComplete(Game game, boolean complete)
}