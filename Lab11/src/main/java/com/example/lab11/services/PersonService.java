package com.example.lab11.services;

import com.example.lab11.entity.Person;
import com.example.lab11.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<Person> getUsers() {
        return personRepository.findAll();
    }

    public void updatePerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

    public List<Person> getMostPopular(int limit) {
        Person MVP = mostPopularPerson();
        List<Person> populars = new ArrayList<>();
        List<Person> current = new ArrayList<>(MVP.getFriends());
        List<Person> newlyAdded = new ArrayList<>();
        populars.add(MVP);
        limit--;
        do {
            for (Person pers : current) {
                if (!populars.contains(pers)) {
                    populars.add(pers);
                    limit--;
                    if (limit == 0) {
                        break;
                    }
                    for (Person person : pers.getFriends()) {
                        if (!populars.contains(person)) {
                            newlyAdded.add(person);
                        }
                    }
                }
            }
            current = new ArrayList<>(newlyAdded);
            newlyAdded = new ArrayList<>();
        } while (!current.isEmpty() && limit != 0);
        return populars;
    }

    public Person mostPopularPerson() {
        var list = personRepository.findAll();
        list.sort(Person::compareTo);
        return list.get(list.size() - 1);
    }
}
