package com.sayakat.housebookingapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
@Getter
@Setter
@NoArgsConstructor
public class Booking extends AuditModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Long booking_id;

    @Column(length = 50, nullable = false)
    private Date check_in;

    @Column(length = 50, nullable = false)
    private Date check_out;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "booker_id")
    private User booker;

    @JoinColumn(name = "house_id")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private House house;




    public Long getBooking_id() {
        return booking_id;
    }
    public void setBooking_id(Long booking_id) {
        this.booking_id = booking_id;
    }
    public Date getCheck_in() {
        return check_in;
    }
    public void setCheck_in(Date check_in) {
        this.check_in = check_in;
    }
    public Date getCheck_out() {
        return check_out;
    }
    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }
    public User getBooker() {
        return booker;
    }
    public void setBooker(User booker) {
        this.booker = booker;
    }
    public House getHouse() {
        return house;
    }
    public void setHouse(House house) {
        this.house = house;
    }
}
