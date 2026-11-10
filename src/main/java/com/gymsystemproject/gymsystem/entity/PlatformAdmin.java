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
@Table(name = "platform_admins")
@Getter @Setter
public class PlatformAdmin extends BaseEntity {

    private String email;
    private String passwordHash;
    private String fullName;
    private boolean active = true;
}
