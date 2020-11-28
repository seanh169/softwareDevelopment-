package com.petclinic.sfgpetclinic.services;

import com.petclinic.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
