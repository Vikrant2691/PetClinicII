package com.petclinic.bootstrap;

import com.petclinic.model.*;
import com.petclinic.services.OwnerService;
import com.petclinic.services.PetService;
import com.petclinic.services.PetTypeService;
import com.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;

    }

    @Override
    public void run(String... args) throws Exception {


        PetType dog = new PetType();
        dog.setId(1L);
        dog.setName("Dog");

        System.out.println("Pet Loaded2..................................."+dog.toString());

        PetType cat = new PetType();
        cat.setId(2L);
        cat.setName("Cat");

        System.out.println("Pet Loaded1..................................."+cat.toString());


        Pet boggy= new Pet();
        boggy.setId(1L);
        boggy.setBirthDate(LocalDate.now());
        boggy.setName("Boggy");
        boggy.setPetType(dog);

        Pet tutty= new Pet();
        tutty.setId(2L);
        tutty.setBirthDate(LocalDate.now());
        tutty.setName("Tutty");
        tutty.setPetType(cat);
        


        Owner micheal = new Owner();
        micheal.setId(1L);
        micheal.setFirstName("Michael");
        micheal.setLastName("Langdon");
        micheal.setAddress("290 Web drive");
        micheal.setCity("Miami");
        micheal.setTelephone("0293847756");
        micheal.getPets().add(boggy);
        ownerService.save(micheal);


        Owner lizzy = new Owner();
        lizzy.setId(2L);
        lizzy.setFirstName("lizzy");
        lizzy.setLastName("Bong");
        lizzy.setAddress("290 Oregon Ville");
        lizzy.setCity("NY");
        lizzy.setTelephone("023498756");
        lizzy.getPets().add(tutty);
        ownerService.save(lizzy);

        System.out.println("Owner Loaded...................................");


        Speciality dogSpecialty = new Speciality();
        dogSpecialty.setId(1L);
        dogSpecialty.setDescription("Dog Speciality");


        Speciality catSpecialty = new Speciality();
        catSpecialty.setId(2L);
        catSpecialty.setDescription("Cat Speciality");
        
        Vet v1 = new Vet();
        v1.setId(1L);
        v1.setFirstName("Jiju");
        v1.setLastName("Safa");
        v1.getSpecialties().add(dogSpecialty);

        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setId(2L);
        v2.setFirstName("One");
        v2.setLastName("Girl");
        v2.getSpecialties().add(catSpecialty);
        vetService.save(v2);




    }
}
