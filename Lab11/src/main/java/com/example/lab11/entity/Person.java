package com.example.lab11.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String username;

    @OneToMany
    private final Set<Person> friends = new HashSet<>();

    public Person(String username) {
        this.username = username;
    }

    public Person() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void addFriend(Person friend) {
        friends.add(friend);
    }

    public void deleteFriend(Person friend) {
        friends.removeIf(fr -> fr.getUsername().equals(friend.getUsername()));
    }

}