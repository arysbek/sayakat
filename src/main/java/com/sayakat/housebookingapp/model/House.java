package com.sayakat.housebookingapp.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "houses")
@Data
public class House extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Long id;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "host_id")
    private User host;

    @OneToMany(mappedBy = "id")
    private List<Photo> photo;

    @ManyToOne
    private Amenity amenity;

}
