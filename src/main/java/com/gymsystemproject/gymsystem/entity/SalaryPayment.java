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
@Table(name = "salary_payments")
@Getter @Setter
public class SalaryPayment extends TenantBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "staff_id")
    private User staff;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "paid_by")
    private User paidBy;

    /** Always the 1st day of the month the salary is for. */
    private LocalDate salaryMonth;

    private BigDecimal baseAmount;
    private BigDecimal bonus = BigDecimal.ZERO;
    private BigDecimal deductions = BigDecimal.ZERO;

    /** Must equal baseAmount + bonus - deductions (enforced by the DB). */
    private BigDecimal netAmount;

    private Instant paidAt;
    private String note;
}
