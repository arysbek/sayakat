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

    private boolean coffee = false;
    private boolean kitchen = false;
    private boolean garage = false;
    private boolean parking = false;
    private boolean laundry = false;
    private boolean entertainment = false;
    private boolean outdoor = false;
    private boolean suitability = false;

}

