package com.shatokhina.fitnessClub.client;

import com.shatokhina.fitnessClub.FitnessServices;
import com.shatokhina.fitnessClub.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.EnumSet;

public class DaySubscription implements Subscription {
    private final EnumSet<FitnessServices> accessServices = EnumSet.of(FitnessServices.GROUP, FitnessServices.GYM);
    private Customer.Builder builder;
    private Customer client;

    public DaySubscription(User user) {
        builder = new Customer.Builder(user);
        builder.timeUntil(LocalTime.of(16, 0));
    }

    public void setDateOfRegistration(LocalDate dateOfRegistration) { builder.dateOfRegistration(dateOfRegistration); }

    public void setDateOfEnd(LocalDate dateOfEnd) { builder.dateOfEnd(dateOfEnd); }

    @Override
    public DaySubscription create() {
        client = builder.build();
        return this;
    }

    @Override
    public User getUser() { return client.getUser(); }

    @Override
    public LocalDate getDateOfRegistration() { return client.getDateOfRegistration(); }

    @Override
    public LocalTime getTimeFrom() { return client.getTimeFrom(); }

    @Override
    public LocalTime getTimeUntil() { return client.getTimeUntil(); }

    @Override
    public EnumSet<FitnessServices> getAccessServices() { return accessServices; }

    @Override
    public LocalDate getDateOfEnd() { return client.getDateOfEnd(); }
}