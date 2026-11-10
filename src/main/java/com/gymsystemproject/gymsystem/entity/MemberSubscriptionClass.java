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

/**
 * Class entitlement ("credits") bought inside a subscription.
 * remaining = quantity - count(member_attendance rows pointing at this row).
 * Lock this row (PESSIMISTIC_WRITE) when consuming a credit so two check-ins cannot overspend it.
 */
@Entity
@Table(name = "member_subscription_classes")
@Getter @Setter
public class MemberSubscriptionClass extends TenantBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_subscription_id")
    private MemberSubscription subscription;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "class_id")
    private GymClass gymClass;

    /** Sessions included. */
    private int quantity = 1;

    /** Total price for all `quantity` sessions (basis of the refund calculation). */
    private BigDecimal allocatedPrice = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    private EntitlementStatus status = EntitlementStatus.ACTIVE;
}
