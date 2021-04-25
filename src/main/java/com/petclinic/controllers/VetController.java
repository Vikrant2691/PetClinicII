package com.petclinic.controllers;

import com.petclinic.model.Vet;
import com.petclinic.services.VetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class VetController {

    private final VetService vetServiceMap;

    public VetController(VetService vetServiceMap) {
        this.vetServiceMap = vetServiceMap;
    }

    @GetMapping("/vets")
    public Set<Vet> getVetData(){
        return vetServiceMap.findAll();
    }
}
