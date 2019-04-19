package com.shatokhina.fitnessClub;

import com.shatokhina.fitnessClub.subscription.Subscription;

import java.time.LocalDate;
import java.util.Optional;

public final class User {
    private final String surname;
    private final String name;
    private final LocalDate dateOfBirth;
    private final Subscription subscription;

    public User(String surname, String name, LocalDate dateOfBirth) {
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.subscription = null;
    }

    public User(String surname, String name, LocalDate dateOfBirth, Subscription subscription) {
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.subscription = subscription;
    }

    public User setSubscription(Subscription subscription) { return new User(surname, name, dateOfBirth, subscription); }

    public Optional<Subscription> getSubscription() { return Optional.ofNullable(subscription); }

    public String getSurname() { return surname; }

    public String getName() { return name; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }

    public User validationOfSubscription() {
        if (subscription != null && subscription.getDateOfEnd().isBefore(LocalDate.now()))
            return new User(surname, name, dateOfBirth);
        return this;
    }

    @Override
    public String toString() {
        Optional<Subscription> subscription = getSubscription();
        String type = "no subscription";
        if (subscription.isPresent()) type = subscription.get().getType();

        return '<' + surname + '>' +
                " <" + name + '>' +
                " <" + type + '>';
    }
}