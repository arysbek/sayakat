package com.sayakat.housebookingapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "amenities")
@Getter
@Setter
@NoArgsConstructor
public class Amenity extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Long id;

    @Column(columnDefinition = "false")
    private boolean coffee;
    @Column(columnDefinition = "false")
    private boolean kitchen;
    @Column(columnDefinition = "false")
    private boolean garage;
    @Column(columnDefinition = "false")
    private boolean parking;
    @Column(columnDefinition = "false")
    private boolean laundry;
    @Column(columnDefinition = "false")
    private boolean entertainment;
    @Column(columnDefinition = "false")
    private boolean outdoor;
    @Column(columnDefinition = "false")
    private boolean suitability;

}

