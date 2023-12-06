package com.mercadolibre.people_list_group_6.repository;

import com.mercadolibre.people_list_group_6.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface PersonRepository  extends  JpaRepository<Person, UUID>{
    List<Person> findByNicknameContainingIgnoreCaseOrNameContainingIgnoreCase(String nickname, String name);

    //List<Person> findByFirstNameStartingWith(String startsWith)
}
