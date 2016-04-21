package com.cardinalhealth.fuse.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

import javax.persistence.Entity
import javax.persistence.ManyToOne

@ToString
@EqualsAndHashCode
@Entity
@JsonIgnoreProperties(["hibernateLazyInitializer", "handler"])
class Game extends BaseDomain {

    @ManyToOne
    Player owner

    @ManyToOne
    Player challenger
}
