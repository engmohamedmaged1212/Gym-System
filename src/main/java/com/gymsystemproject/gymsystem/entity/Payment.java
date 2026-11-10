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
@Table(name = "payments")
@Getter @Setter
public class Payment extends TenantBaseEntity {

    private String receiptNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subscription_id")
    private MemberSubscription subscription;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "received_by")
    private User receivedBy;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod method = PaymentMethod.CASH;

    private Instant paidAt;
    private String note;
}
