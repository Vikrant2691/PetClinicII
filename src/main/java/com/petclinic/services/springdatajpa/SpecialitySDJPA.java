package com.petclinic.services.springdatajpa;

import com.petclinic.model.Speciality;
import com.petclinic.repositories.SpecialityRepository;
import com.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Primary
public class SpecialitySDJPA implements SpecialityService {

    private final SpecialityRepository repository;

    public SpecialitySDJPA(SpecialityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Speciality> findAll() {

        Set<Speciality> specialities = new HashSet<>();
        repository.findAll().forEach(specialities::add);

        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return repository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return repository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
