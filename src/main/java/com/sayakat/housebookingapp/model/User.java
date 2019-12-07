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

    @Column(length = 10, nullable = false, unique = true)
    private String phoneNumber;

    @Lob
    @Column(name = "profile_pic", columnDefinition="BLOB", nullable = true)
    private byte[] profilePic;




    public Long getUser_id() {
        return user_id;
    }
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public byte[] getProfilePic() {
        return profilePic;
    }
    public void setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
    }
}
