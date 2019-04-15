package com.shatokhina.fitnessClub.client;

import com.shatokhina.fitnessClub.User;
import java.time.LocalDate;
import java.time.LocalTime;

final class Customer {
    private final User user;
    private final LocalDate dateOfRegistration;
    private final LocalTime timeFrom = LocalTime.of(8, 0);
    private final LocalTime timeUntil;
    private final LocalDate dateOfEnd;

    private Customer(Builder builder) {
        this.user = builder.user;
        this.dateOfRegistration = builder.dateOfRegistration;
        this.dateOfEnd = builder.dateOfEnd;
        this.timeUntil = builder.timeUntil;
    }

    User getUser() { return user; }

    LocalDate getDateOfRegistration() { return dateOfRegistration; }

    LocalTime getTimeFrom() { return timeFrom; }

    LocalTime getTimeUntil() { return timeUntil; }

    LocalDate getDateOfEnd() { return dateOfEnd; }

    static class Builder {
        private final User user;
        private LocalDate dateOfRegistration = LocalDate.now();
        private LocalDate dateOfEnd = dateOfRegistration.plusMonths(12);
        private LocalTime timeUntil = LocalTime.of(22, 0);

        Builder(User user) { this.user = user; }

        Builder dateOfRegistration(LocalDate value) {
            this.dateOfRegistration = value;
            return this;
        }

        Builder dateOfEnd(LocalDate value) {
            this.dateOfEnd = value;
            return this;
        }

        Builder timeUntil(LocalTime value) {
            this.timeUntil = value;
            return this;
        }

        Customer build() { return new Customer(this); }
    }
}