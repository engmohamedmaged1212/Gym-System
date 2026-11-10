package com.gymsystemproject.gymsystem.entity;

import com.gymsystemproject.gymsystem.entity.enums.*;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gym_classes")
@Getter @Setter
public class GymClass extends TenantBaseEntity {

    private String name;
    private String description;

    /** null = offered at all branches. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @Enumerated(EnumType.STRING)
    private ClassStatus status = ClassStatus.ACTIVE;

    private Instant discontinuedAt;
    private String discontinuedReason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discontinued_by")
    private User discontinuedBy;
}
