package com.shatokhina.fitnessClub;

import java.time.LocalDate;

public class User {
    private final String surname;
    private final String name;
    private final LocalDate dateOfBirth;

    public User(String surname, String name, LocalDate dateOfBirth) {
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getSurname() { return surname; }

    public String getName() { return name; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
}