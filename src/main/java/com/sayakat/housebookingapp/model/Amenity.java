package com.sayakat.housebookingapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "amenity")
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

    @OneToOne
    private House house;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean isCoffee() {
        return coffee;
    }
    public void setCoffee(boolean coffee) {
        this.coffee = coffee;
    }
    public boolean isKitchen() {
        return kitchen;
    }
    public void setKitchen(boolean kitchen) {
        this.kitchen = kitchen;
    }
    public boolean isGarage() {
        return garage;
    }
    public void setGarage(boolean garage) {
        this.garage = garage;
    }
    public boolean isParking() {
        return parking;
    }
    public void setParking(boolean parking) {
        this.parking = parking;
    }
    public boolean isLaundry() {
        return laundry;
    }
    public void setLaundry(boolean laundry) {
        this.laundry = laundry;
    }
    public boolean isEntertainment() {
        return entertainment;
    }
    public void setEntertainment(boolean entertainment) {
        this.entertainment = entertainment;
    }
    public boolean isOutdoor() {
        return outdoor;
    }
    public void setOutdoor(boolean outdoor) {
        this.outdoor = outdoor;
    }
    public boolean isSuitability() {
        return suitability;
    }
    public void setSuitability(boolean suitability) {
        this.suitability = suitability;
    }
}

