package com.petclinic.bootstrap;

import com.petclinic.model.Owner;
import com.petclinic.model.Pet;
import com.petclinic.model.PetType;
import com.petclinic.model.Speciality;
import com.petclinic.model.Vet;
import com.petclinic.services.springdatajpa.OwnerSDJPA;
import com.petclinic.services.springdatajpa.SpecialitySDJPA;
import com.petclinic.services.springdatajpa.VetSDJPA;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component

public class DataLoader implements CommandLineRunner {


    private final OwnerSDJPA ownerService;
    private final VetSDJPA vetService;
    private final SpecialitySDJPA specialitySDJPA;


    public DataLoader(OwnerSDJPA ownerService, VetSDJPA vetService, SpecialitySDJPA specialitySDJPA) {
        this.ownerService = ownerService;
        this.vetService = vetService;

        this.specialitySDJPA = specialitySDJPA;
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


        Owner micheal = Owner.builder()
                .id(1L)
                .firstName("Michael")
                .lastName("Langdon")
                .address("290 Web drive")
                .city("Miami")
                .telephone("0293847756").build();
        ownerService.save(micheal);

        System.out.println(micheal.getAddress());

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

        specialitySDJPA.save(dogSpecialty);

        Speciality catSpecialty = new Speciality();
        catSpecialty.setId(2L);
        catSpecialty.setDescription("Cat Speciality");

        specialitySDJPA.save(catSpecialty);

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
