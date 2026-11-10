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

/** Created when a class is discontinued and a member still has unused credits for it. */
@Entity
@Table(name = "class_settlements")
@Getter @Setter
public class ClassSettlement extends TenantBaseEntity {

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_subscription_class_id")
    private MemberSubscriptionClass memberSubscriptionClass;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "class_id")
    private GymClass gymClass;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

    private BigDecimal refundAmount;

    @Enumerated(EnumType.STRING)
    private SettlementStatus status = SettlementStatus.PENDING;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "refund_id")
    private Refund refund;

    private Instant settledAt;
    private String note;
}
