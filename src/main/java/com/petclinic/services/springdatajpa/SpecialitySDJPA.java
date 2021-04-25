package com.petclinic.services.springdatajpa;

import com.petclinic.model.Speciality;
import com.petclinic.repositories.SpecialityRepository;
import com.petclinic.services.SpecialityService;

import java.util.Set;

public class SpecialitySDJPA implements SpecialityService {

    private final SpecialityRepository repository;

    public SpecialitySDJPA(SpecialityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Speciality> findAll() {
        return (Set<Speciality>) repository.findAll();
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
