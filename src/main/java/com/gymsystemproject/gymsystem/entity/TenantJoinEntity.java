package com.gymsystemproject.gymsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.TenantId;

/** Base for tenant-scoped join tables (composite key, no id / timestamps). */
@MappedSuperclass
@Getter
@Setter
public abstract class TenantJoinEntity {

    @TenantId
    @Column(name = "gym_id", nullable = false, updatable = false)
    private Long gymId;
}
