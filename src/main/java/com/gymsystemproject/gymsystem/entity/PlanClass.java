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
@Table(name = "plan_classes")
@Getter @Setter
public class PlanClass extends TenantJoinEntity {

    @EmbeddedId
    private Key id = new Key();

    @MapsId("planId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plan_id")
    private SubscriptionPlan plan;

    @MapsId("classId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "class_id")
    private GymClass gymClass;

    /** Number of sessions of this class included in the plan. */
    private int includedQuantity = 1;

    @Embeddable
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
    public static class Key implements Serializable {
        @Column(name = "plan_id") private Long planId;
        @Column(name = "class_id") private Long classId;
    }
}
