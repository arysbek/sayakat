package com.sayakat.housebookingapp.model;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Data
public class User extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Long id;

    @Column(length = 50, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 250, nullable = false)
    private String address;

    @Column(length = 30, nullable = false)
    private Date dateOfBirth;

    @Column(length = 10, nullable = false, unique = true)
    private String phoneNumber;

    @Lob
    @Column(name = "profile_pic", columnDefinition="BLOB", nullable = true)
    private byte[] profilePic;

}
