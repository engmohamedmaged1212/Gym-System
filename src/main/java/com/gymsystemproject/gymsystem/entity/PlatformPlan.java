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
@Table(name = "platform_plans")
@Getter @Setter
public class PlatformPlan extends BaseEntity {

    private String name;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private BillingPeriod billingPeriod = BillingPeriod.MONTHLY;

    private Integer maxBranches;   // null = unlimited
    private Integer maxMembers;    // null = unlimited
    private boolean active = true;
}
