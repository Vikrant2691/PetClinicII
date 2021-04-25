package com.petclinic.controllers;

import com.petclinic.model.Owner;
import com.petclinic.model.PetType;
import com.petclinic.services.map.OwnerServiceMap;
import com.petclinic.services.map.PetServiceMap;
import com.petclinic.services.map.PetTypeServiceMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class IndexController {

    private final OwnerServiceMap ownerServiceMap;
    private final PetTypeServiceMap petTypeServiceMap;

    public IndexController(OwnerServiceMap ownerServiceMap, PetTypeServiceMap petTypeServiceMap) {
        this.ownerServiceMap = ownerServiceMap;
        this.petTypeServiceMap = petTypeServiceMap;
    }

    @RequestMapping({"/", "", "index", "index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping({"/owners"})
    public Set<Owner> owners() {
        return ownerServiceMap.findAll();
    }

    @RequestMapping(path = "/pettypes")
    public Set<PetType> petTypes() {
        return petTypeServiceMap.findAll();
    }
}
