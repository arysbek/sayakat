package com.sayakat.housebookingapp.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "photo")
@Getter
@Setter
@NoArgsConstructor
public class Photo extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Long photo_id;

    @Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] photo;


    public Long getPhoto_id() {
        return photo_id;
    }
    public void setPhoto_id(Long photo_id) {
        this.photo_id = photo_id;
    }
    public byte[] getPhoto() {
        return photo;
    }
    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
