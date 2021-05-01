package com.petclinic.services.map;

import com.petclinic.model.Owner;
import com.petclinic.services.OwnerService;
import com.petclinic.services.PetService;
import com.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;


@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }


    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Owner save(Owner object) {

        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        petTypeService.save(pet.getPetType());
                    } else {
                        throw new RuntimeException("PetType is required");
                    }
                    petService.save(pet);
                });
            }
            return super.save(object.getId(), object);
        } else {
            return null;
        }

    }


    @Override
    public Owner findByLastname(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }
}
