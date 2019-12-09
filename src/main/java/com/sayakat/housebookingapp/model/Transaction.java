package com.sayakat.housebookingapp.model;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Transaction extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Long id;

    @Column(name = "transaction_id", nullable = false)
    private String transactionId;

    @Column(name = "amount", nullable = false)
    private Long amount;


}

