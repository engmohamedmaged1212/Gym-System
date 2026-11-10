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
@Table(name = "class_trainers")
@Getter @Setter
public class ClassTrainer extends TenantJoinEntity {

    @EmbeddedId
    private Key id = new Key();

    @MapsId("classId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "class_id")
    private GymClass gymClass;

    @MapsId("trainerId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trainer_id")
    private User trainer;

    @Embeddable
    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
    public static class Key implements Serializable {
        @Column(name = "class_id") private Long classId;
        @Column(name = "trainer_id") private Long trainerId;
    }
}
