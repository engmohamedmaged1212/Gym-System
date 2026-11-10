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
@Table(name = "users")
@Getter @Setter
public class User extends TenantBaseEntity {

    private String email;
    private String passwordHash;
    private String fullName;
    private String phone;

    @Enumerated(EnumType.STRING)
    private UserType userType = UserType.STAFF;

    private boolean active = true;
    private Instant lastLoginAt;
}
