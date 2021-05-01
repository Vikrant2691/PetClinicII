package com.petclinic.services.springdatajpa;

import com.petclinic.model.Visit;
import com.petclinic.repositories.VisitRepository;
import com.petclinic.services.VisitService;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Primary
public class VisitSDJPA implements VisitService {

    public VisitSDJPA(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    private final VisitRepository visitRepository;


    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
