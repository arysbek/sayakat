package com.sayakat.housebookingapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "phoneNumber")
@Getter
@Setter
@NoArgsConstructor
public class PhoneNumber extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Long id;

    @Column(length = 10, nullable = false)
    private String phoneNumber;

    @Column(length = 50, nullable = false)
    private String phone_desc;
}
