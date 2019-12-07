package com.sayakat.housebookingapp.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor
public class User extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Long user_id;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 250, nullable = false)
    private String address;

    @Column(length = 30, nullable = false)
    private Date dateOfBirth;

    @Lob
    @Column(name = "profile_pic", columnDefinition="BLOB", nullable = true)
    private byte[] profilePic;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PhoneNumber phoneNumber;

}
