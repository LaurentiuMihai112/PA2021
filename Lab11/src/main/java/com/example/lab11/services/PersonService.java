package com.example.lab11.services;

import com.example.lab11.entity.Person;
import com.example.lab11.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person getPersonByUsername(String username) {
        return personRepository.findPersonByUsername(username);
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public List<Person> getUses() {
        return personRepository.findAll();
    }

    public void updatePerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Person person) {
        personRepository.delete(person);
    }
}
