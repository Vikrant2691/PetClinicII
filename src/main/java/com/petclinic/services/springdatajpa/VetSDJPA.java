package com.petclinic.services.springdatajpa;

import com.petclinic.model.Vet;
import com.petclinic.repositories.VetRepository;
import com.petclinic.services.VetService;

import java.util.Set;

public class VetSDJPA implements VetService {

    private final VetRepository vetRepository;

    public VetSDJPA(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        return (Set<Vet>) vetRepository.findAll();
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
