package com.mercadolibre.people_list_group_6.service;

import com.mercadolibre.people_list_group_6.model.Person;
import com.mercadolibre.people_list_group_6.model.Stack;
import com.mercadolibre.people_list_group_6.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public Person create(Person person){
        return personRepository.save(person);
    }

    public void update(UUID id, Person updatedPerson) {
        Person existingPerson = personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Person not found with id: " + id));

        existingPerson.setName(updatedPerson.getName());
        existingPerson.setNickname(updatedPerson.getNickname());
        existingPerson.setBirthday(updatedPerson.getBirthday());

        personRepository.save(existingPerson);
    }

    public void delete(UUID id) {
        personRepository.deleteById(id);
    }

    public long getPersonCount() {
        return personRepository.count();
    }
}
