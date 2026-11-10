package com.gymsystemproject.gymsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.TenantId;

/**
 * Base for every tenant-scoped table that has its own id.
 * Hibernate fills gym_id on insert and adds "gym_id = :current" to every query.
 */
@MappedSuperclass
@Getter
@Setter
public abstract class TenantBaseEntity extends BaseEntity {

    @TenantId
    @Column(name = "gym_id", nullable = false, updatable = false)
    private Long gymId;
}
