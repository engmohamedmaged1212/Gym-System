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

/** Branches allowed for a subscription whose branchAccess = SELECTED_BRANCHES (copied from plan_branches at sale). */
@Entity
@Table(name = "member_subscription_branches")
@Getter @Setter
public class MemberSubscriptionBranch extends TenantJoinEntity {

    @EmbeddedId
    private Key id = new Key();

    @MapsId("subscriptionId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_subscription_id")
    private MemberSubscription subscription;

    @MapsId("branchId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @Embeddable
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
    public static class Key implements Serializable {
        @Column(name = "member_subscription_id") private Long subscriptionId;
        @Column(name = "branch_id") private Long branchId;
    }
}
