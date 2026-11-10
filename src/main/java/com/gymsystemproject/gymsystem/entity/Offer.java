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
@Table(name = "offers")
@Getter @Setter
public class Offer extends TenantBaseEntity {

    private String name;

    /** Optional promo code, unique per gym. */
    private String code;

    @Enumerated(EnumType.STRING)
    private DiscountType discountType;

    private BigDecimal discountValue;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active = true;
}
