package com.cardinalhealth.fuse.domain

import javax.persistence.Entity

@Entity
class Player extends BaseDomain {

    String name
    String avatar
    String deviceId
}
