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

/** Fixed catalog of permission codes (seeded by you, referenced from code). */
@Entity
@Table(name = "permissions")
@Getter @Setter
public class Permission {

    @Id
    private String code;
    private String category;
    private String description;
}
