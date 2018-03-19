package com.sean.LanguagesReloaded.repositories;





import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import com.sean.LanguagesReloaded.models.languages;


@Repository
public interface LanguageRespository extends CrudRepository<languages, Long> {

}
