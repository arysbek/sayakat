package com.sayakat.housebookingapp.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "amenity")
@Data
public class Amenity extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Long id;

    private boolean coffee;
    private boolean kitchen;
    private boolean garage;
    private boolean parking;
    private boolean laundry;
    private boolean entertainment;
    private boolean outdoor;
    private boolean suitability;

}

