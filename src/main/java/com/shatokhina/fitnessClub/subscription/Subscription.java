package com.shatokhina.fitnessClub.subscription;

import com.shatokhina.fitnessClub.FitnessService;
import com.shatokhina.fitnessClub.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

final class Subscription {
    private final User user;
    private final LocalDate dateOfRegistration;
    private final LocalTime timeFrom = LocalTime.of(8, 0);
    private final LocalTime timeUntil;
    private final LocalDate dateOfEnd;
    private final Set<FitnessService> fitnessServices;

    public Subscription(User user, Set<FitnessService> services,
                        LocalDate dateOfRegistration, LocalTime timeUntil, LocalDate dateOfEnd) {       // Group times gather
        this.user = user;
        this.dateOfRegistration = dateOfRegistration;
        this.timeUntil = timeUntil;
        this.dateOfEnd = dateOfEnd;
        this.fitnessServices = services;
    }

    User getUser() { return user; }

    LocalDate getDateOfRegistration() { return dateOfRegistration; }

    LocalTime getTimeFrom() { return timeFrom; }

    LocalTime getTimeUntil() { return timeUntil; }

    LocalDate getDateOfEnd() { return dateOfEnd; }

    public Set<FitnessService> getFitnessServices() { return fitnessServices; }
}