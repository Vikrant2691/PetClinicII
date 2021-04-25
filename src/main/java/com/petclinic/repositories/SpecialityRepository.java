package com.petclinic.repositories;

import com.petclinic.model.PetType;
import com.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality,Long> {
}
