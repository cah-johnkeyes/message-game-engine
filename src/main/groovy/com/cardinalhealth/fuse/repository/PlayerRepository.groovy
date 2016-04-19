package com.cardinalhealth.fuse.repository

import com.cardinalhealth.fuse.domain.Player
import org.springframework.data.jpa.repository.JpaRepository

interface PlayerRepository extends JpaRepository<Player, Integer> {
}