package com.petclinic.services.map;

import com.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class OwnerServiceMapTest {

    OwnerServiceMap serviceMap;



    @BeforeEach
    void setUp() {
        serviceMap= new OwnerServiceMap(new PetServiceMap(),new PetTypeServiceMap());
        Owner owner1= Owner.builder().id(1L).firstName("Vikrant").lastName("Sonawane").build();
        Owner owner2= Owner.builder().id(2L).firstName("Snehal").lastName("Baviskar").build();
        serviceMap.save(owner1);
        serviceMap.save(owner2);
    }

    @Test
    void findAll() {
        assertEquals(serviceMap.findAll().size(),2);
    }

    @Test
    void deleteById() {

        serviceMap.deleteById(1L);
        assertNull(serviceMap.findById(1L));
    }

    @Test
    void delete() {
        Owner ownerToBDeleted= Owner.builder().id(1L).firstName("Vikrant").lastName("Sonawane").build();
        serviceMap.delete(ownerToBDeleted);
        assertNotEquals(serviceMap.findById(1L),ownerToBDeleted);
    }

    @Test
    void findById() {

        assertEquals(serviceMap.findById(1L).getFirstName(),"Vikrant");
    }

    @Test
    void save() {
        serviceMap.save(Owner.builder().id(3L).firstName("Mona").lastName("Ruchkar").build());
        assertEquals(serviceMap.findAll().size(),3);
        assertEquals(serviceMap.findById(3L).getFirstName(),"Mona");

    }

    @Test
    void findByLastname() {

        assertEquals(serviceMap.findByLastname("Sonawane").getFirstName(),"Vikrant");

    }
}