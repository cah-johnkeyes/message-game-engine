package com.cardinalhealth.fuse.repository

import com.cardinalhealth.fuse.domain.Exchange
import org.springframework.data.jpa.repository.JpaRepository

interface ExchangeRepository extends JpaRepository<Exchange, Integer> { }