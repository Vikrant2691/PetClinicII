package com.petclinic.controllers;

import com.petclinic.model.Owner;
import com.petclinic.model.PetType;
import com.petclinic.model.Vet;
import com.petclinic.services.springdatajpa.OwnerSDJPA;
import com.petclinic.services.springdatajpa.PetSDJPA;
import com.petclinic.services.springdatajpa.PetTypeSDJPA;
import com.petclinic.services.springdatajpa.VetSDJPA;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Slf4j
@RestController
public class IndexController {

    private final OwnerSDJPA ownerSDJPA;
    private final PetSDJPA petSDJPA;
    private final PetTypeSDJPA petTypeSDJPA;
    private final VetSDJPA vetSDJPA;

    public IndexController(OwnerSDJPA ownerServiceMap, PetSDJPA petSDJPA, PetTypeSDJPA petTypeSDJPA, VetSDJPA vetSDJPA) {
        this.ownerSDJPA = ownerServiceMap;
        this.petSDJPA = petSDJPA;
        this.petTypeSDJPA = petTypeSDJPA;
        this.vetSDJPA = vetSDJPA;
    }

    @RequestMapping({"/", "", "index", "index.html"})
    public String index() {
        log.info("Hi there");
        return "index";
    }

    @RequestMapping({"/owners"})
    public Set<Owner> owners() {
        return ownerSDJPA.findAll();
    }

    @RequestMapping(path = "/pettypes")
    public Set<PetType> petTypes() {
        return petTypeSDJPA.findAll();
    }

    @RequestMapping(path = "/vets")
    public Set<Vet> getVets() {
        return vetSDJPA.findAll();
    }
}
