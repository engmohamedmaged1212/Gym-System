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
@Table(name = "offer_plans")
@Getter @Setter
public class OfferPlan extends TenantJoinEntity {

    @EmbeddedId
    private Key id = new Key();

    @MapsId("offerId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @MapsId("planId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plan_id")
    private SubscriptionPlan plan;

    @Embeddable
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
    public static class Key implements Serializable {
        @Column(name = "offer_id") private Long offerId;
        @Column(name = "plan_id") private Long planId;
    }
}
