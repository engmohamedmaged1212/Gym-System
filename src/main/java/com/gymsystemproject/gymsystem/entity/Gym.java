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
@Table(name = "gyms")
@Getter @Setter
public class Gym extends BaseEntity {

    private String code;
    private String name;
    private String timezone = "UTC";

    @Enumerated(EnumType.STRING)
    private GymStatus status = GymStatus.ACTIVE;

    private boolean allowMemberCrossBranch;
    private boolean allowStaffMultiBranch;
    private boolean memberAccountsEnabled;
}
