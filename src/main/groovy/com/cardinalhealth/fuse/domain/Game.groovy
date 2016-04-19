package com.cardinalhealth.fuse.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.Entity
import javax.persistence.ManyToOne

@ToString
@EqualsAndHashCode
@Entity
class Game extends BaseDomain {

    @ManyToOne
    Player owner

    @ManyToOne
    Player challenger
}
