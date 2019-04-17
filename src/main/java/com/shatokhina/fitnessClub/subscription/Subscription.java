package com.shatokhina.fitnessClub.subscription;

import com.shatokhina.fitnessClub.FitnessService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public final class Subscription {
    private final String type;
    private final LocalDate dateOfRegistration;
    private final LocalTime timeFrom = LocalTime.of(8, 0);
    private final LocalTime timeUntil;
    private final LocalDate dateOfEnd;
    private final Set<FitnessService> fitnessServices;

    Subscription(String type, Set<FitnessService> services, LocalDate dateOfRegistration, LocalTime timeUntil, LocalDate dateOfEnd) {       // Group times gather
        this.type = type;
        this.dateOfRegistration = dateOfRegistration;
        this.timeUntil = timeUntil;
        this.dateOfEnd = dateOfEnd;
        this.fitnessServices = services;
    }

    public LocalDate getDateOfRegistration() { return dateOfRegistration; }

    public LocalTime getTimeFrom() { return timeFrom; }

    public LocalTime getTimeUntil() { return timeUntil; }

    public LocalDate getDateOfEnd() { return dateOfEnd; }

    public Set<FitnessService> getFitnessServices() { return fitnessServices; }

    public String getType() { return type; }
}