package com.petclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "vets")
public class Vet extends Person {

    @ManyToMany
    @JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialties = new HashSet<>();

    public Set<Speciality> getSpecialties() {
        return specialties;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialties = specialities;
    }
}
