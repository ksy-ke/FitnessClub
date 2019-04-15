package com.shatokhina.fitnessClub;

import com.shatokhina.fitnessClub.client.Subscription;

import java.time.LocalDate;

public class User {
    private final String surname;
    private final String name;
    private final LocalDate dateOfBirth;
    private Subscription typeOfSubscription;

    public User(String surname, String name, LocalDate dateOfBirth) {
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public void setType(Subscription subscription) { typeOfSubscription = subscription; }

    public Subscription getTypeOfSubscription() { return typeOfSubscription; }

    public String getSurname() { return surname; }

    public String getName() { return name; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
}