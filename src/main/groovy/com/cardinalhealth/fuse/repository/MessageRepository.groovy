package com.cardinalhealth.fuse.repository

import com.cardinalhealth.fuse.domain.Message
import org.springframework.data.jpa.repository.JpaRepository

interface MessageRepository extends JpaRepository<Message, Integer> {}