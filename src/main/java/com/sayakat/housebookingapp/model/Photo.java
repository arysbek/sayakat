package com.sayakat.housebookingapp.model;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "photo")
@Data
public class Photo extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Long id;

    @Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;

}
