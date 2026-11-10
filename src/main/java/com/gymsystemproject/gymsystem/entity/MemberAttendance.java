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
 * Every visit of a member.
 *  - gym visit:   gymClass = null
 *  - class visit: gymClass set; memberSubscriptionClass set when it consumes a credit
 */
@Entity
@Table(name = "member_attendance")
@Getter @Setter
public class MemberAttendance extends TenantBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscription_id")
    private MemberSubscription subscription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
    private GymClass gymClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_subscription_class_id")
    private MemberSubscriptionClass memberSubscriptionClass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recorded_by")
    private User recordedBy;

    private Instant checkIn;
    private Instant checkOut;
}
