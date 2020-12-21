package com.petclinic.sfgpetclinic.bootstrap;

import com.petclinic.sfgpetclinic.model.*;
import com.petclinic.sfgpetclinic.services.OwnerService;
import com.petclinic.sfgpetclinic.services.PetTypeService;
import com.petclinic.sfgpetclinic.services.SpecialityService;
import com.petclinic.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();


        if(count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

        Owner owner1 = new Owner();

        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Main St.");
        owner1.setCity("Columbia");
        owner1.setTelephone("123456789");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();

        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenname");
        owner2.setAddress("456 Happy St.");
        owner2.setCity("Baltimore");
        owner2.setTelephone("9654443631");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatPetType);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners.....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("John");
        vet2.setLastName("Smith");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets.....");
    }


}
