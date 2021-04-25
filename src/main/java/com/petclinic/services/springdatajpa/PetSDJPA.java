package com.petclinic.services.springdatajpa;

import com.petclinic.model.Pet;
import com.petclinic.repositories.PetRepository;
import com.petclinic.services.PetService;

import java.util.Optional;
import java.util.Set;

public class PetSDJPA implements PetService {

    private final PetRepository petRepository;

    public PetSDJPA(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        return (Set<Pet>) petRepository.findAll();
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        deleteById(aLong);
    }
}
