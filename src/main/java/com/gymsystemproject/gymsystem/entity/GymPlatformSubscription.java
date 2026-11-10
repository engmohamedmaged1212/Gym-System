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
@Table(name = "gym_platform_subscriptions")
@Getter @Setter
public class GymPlatformSubscription extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gym_id")
    private Gym gym;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "platform_plan_id")
    private PlatformPlan platformPlan;

    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal pricePaid;

    @Enumerated(EnumType.STRING)
    private SubscriptionStatus status = SubscriptionStatus.ACTIVE;
}
