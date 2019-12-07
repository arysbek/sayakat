package com.sayakat.housebookingapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "houses")
@Getter
@Setter
@NoArgsConstructor
public class House extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Long house_id;

    @Column(length = 50, nullable = false)
    private String address;

    @Column(length = 50, nullable = false)
    private String city;

    @Column(length = 250, nullable = false)
    private String description;

    @Column(length = 50, nullable = false)
    private Byte numberOfRooms;

    @Column(length = 50)
    private Byte numberOfBath;

    @Column(length = 50, nullable = false)
    private double price;

    @Column(length = 50)
    private String rules;

    @Column(length = 1)
    private Byte numberOfGuests;


    @OneToOne(mappedBy = "host_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User host;

    @OneToMany(mappedBy = "photo_id")
    private List<Photo> photo;

}
