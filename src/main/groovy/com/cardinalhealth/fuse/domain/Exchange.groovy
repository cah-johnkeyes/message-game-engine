package com.cardinalhealth.fuse.domain

import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
class Exchange extends BaseDomain {
    @ManyToOne
    Game game

    @ManyToOne
    Message initialMessage

    @ManyToOne
    Message responseMessage
}
