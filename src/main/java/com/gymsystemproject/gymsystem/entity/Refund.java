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
@Table(name = "refunds")
@Getter @Setter
public class Refund extends TenantBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subscription_id")
    private MemberSubscription subscription;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "issued_by")
    private User issuedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private RefundType refundType;

    private BigDecimal amount;
    private Instant refundedAt;
    private String reason;
}
