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
 * The DB-managed column open_shift (unique "one open shift per user") is intentionally NOT mapped.
 * A second open shift for the same user will fail with a duplicate-key error: catch it in the service.
 */
@Entity
@Table(name = "staff_attendance")
@Getter @Setter
public class StaffAttendance extends TenantBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    private Instant clockIn;
    private Instant clockOut;
    private String note;
}
