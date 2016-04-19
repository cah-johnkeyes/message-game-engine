package com.cardinalhealth.fuse.repository

import com.cardinalhealth.fuse.domain.Game
import org.springframework.data.jpa.repository.JpaRepository

interface GameRepository extends JpaRepository<Game, Integer> {}