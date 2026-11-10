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
@Table(name = "staff_profiles")
@Getter @Setter
public class StaffProfile extends TenantBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    private String jobTitle;
    private BigDecimal baseSalary = BigDecimal.ZERO;
    private LocalDate hireDate;
    private boolean active = true;
}
