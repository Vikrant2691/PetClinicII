package com.petclinic.services.map;

import com.petclinic.model.Vet;
import com.petclinic.services.SpecialityService;
import com.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
super.delete(object);
    }

    @Override
    public Vet save(Vet object) {

        if(object!=null){
            object.getSpecialties().forEach(specialityService::save);
        }

        assert object != null;
        return super.save(object.getId(),object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
