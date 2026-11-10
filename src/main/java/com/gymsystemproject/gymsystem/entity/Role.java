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
@Table(name = "roles")
@Getter @Setter
public class Role extends TenantBaseEntity {

    private String name;
    private String description;

    /** Owner role: treated as having every permission (also future ones) in the service layer. */
    private boolean ownerRole;

    /** Codes from the permissions table (role_permissions). */
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "role_permissions", joinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "permission_code")
    private Set<String> permissionCodes = new HashSet<>();
}
