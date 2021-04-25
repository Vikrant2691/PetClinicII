package com.petclinic.model;

import javax.persistence.*;
import java.security.PrivateKey;
import java.util.Set;

@Entity
@Table(name = "specialties")
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
