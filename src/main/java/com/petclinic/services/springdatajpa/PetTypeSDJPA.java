package com.petclinic.services.springdatajpa;

import com.petclinic.model.PetType;
import com.petclinic.repositories.PetTypeRepository;
import com.petclinic.services.PetTypeService;

import java.util.Set;

public class PetTypeSDJPA implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJPA(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        return (Set<PetType>) petTypeRepository.findAll();
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
