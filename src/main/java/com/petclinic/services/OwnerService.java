package com.petclinic.services;

import com.petclinic.model.Owner;

import java.util.Optional;


public interface OwnerService extends CrudService<Owner,Long> {


    Owner findByLastname(String lastName);


}
