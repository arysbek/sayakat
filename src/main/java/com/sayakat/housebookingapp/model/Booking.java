package com.sayakat.housebookingapp.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
@Data
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

}
