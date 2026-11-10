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
@Table(name = "members")
@Getter @Setter
public class Member extends TenantBaseEntity {

    /** Only set when the gym enables member accounts and this member has a login. */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "home_branch_id")
    private Branch homeBranch;

    private String fullName;
    private String phone;
    private String email;
    private LocalDate dateOfBirth;
    private LocalDate joinedDate;

    @Enumerated(EnumType.STRING)
    private MemberStatus status = MemberStatus.ACTIVE;

    private String notes;
}
