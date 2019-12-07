package com.sayakat.housebookingapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User host;

    @OneToMany(mappedBy = "photo_id")
    private List<Photo> photo;


    public Long getHouse_id() {
        return id;
    }
    public void setHouse_id(Long house_id) {
        this.id = house_id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Byte getNumberOfRooms() {
        return numberOfRooms;
    }
    public void setNumberOfRooms(Byte numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
    public Byte getNumberOfBath() {
        return numberOfBath;
    }
    public void setNumberOfBath(Byte numberOfBath) {
        this.numberOfBath = numberOfBath;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getRules() {
        return rules;
    }
    public void setRules(String rules) {
        this.rules = rules;
    }
    public Byte getNumberOfGuests() {
        return numberOfGuests;
    }
    public void setNumberOfGuests(Byte numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }
    public User getHost() {
        return host;
    }
    public void setHost(User host) {
        this.host = host;
    }
    public List<Photo> getPhoto() {
        return photo;
    }
    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }
}
