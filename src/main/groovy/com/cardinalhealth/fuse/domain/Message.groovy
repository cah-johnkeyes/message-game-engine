package com.cardinalhealth.fuse.domain

import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
class Message extends BaseDomain {
    String value

    @ManyToOne
    Player player
}
