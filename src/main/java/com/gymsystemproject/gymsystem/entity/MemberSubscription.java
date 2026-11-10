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
 * A purchase. Prices, includesGymAccess and branchAccess are SNAPSHOTS taken from the plan at sale time,
 * so editing a plan later never changes what an existing customer bought.
 */
@Entity
@Table(name = "member_subscriptions")
@Getter @Setter
public class MemberSubscription extends TenantBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plan_id")
    private SubscriptionPlan plan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offer_id")
    private Offer offer;

    /** Branch where it was sold; also the single allowed branch when branchAccess = ONE_BRANCH. */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sold_by")
    private User soldBy;

    private LocalDate startDate;
    private LocalDate endDate;
    private boolean includesGymAccess;

    @Enumerated(EnumType.STRING)
    private BranchAccess branchAccess = BranchAccess.ONE_BRANCH;

    private BigDecimal listPrice;
    private BigDecimal discountAmount = BigDecimal.ZERO;
    private BigDecimal finalPrice;

    @Enumerated(EnumType.STRING)
    private SubscriptionStatus status = SubscriptionStatus.ACTIVE;

    private Instant cancelledAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cancelled_by")
    private User cancelledBy;
}
