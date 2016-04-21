package com.cardinalhealth.fuse.domain

import javax.persistence.*

@MappedSuperclass
abstract class BaseDomain implements Serializable {

    @Id
    @GeneratedValue
    Integer id

    Date dateCreated

    Date lastUpdated

    @PrePersist
    void onCreate() {
        dateCreated = new Date()
        lastUpdated = new Date()
    }

    @PreUpdate
    void onUpdate() {
        lastUpdated = new Date()
    }

    String getClassName() {
        return this.class.simpleName
    }
}
