package com.shatokhina.fitnessClub.client;

import com.shatokhina.fitnessClub.FitnessServices;
import com.shatokhina.fitnessClub.User;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.EnumSet;

public final class FullDaySubscription implements Subscription {
    private final EnumSet<FitnessServices> accessServices = EnumSet.of(FitnessServices.GROUP, FitnessServices.GYM, FitnessServices.POOL);
    private final Customer.Builder builder;
    private Customer client;
    private boolean isCreated = false;

    public FullDaySubscription(User user) {
        builder = new Customer.Builder(user);
    }

    public void setDateOfRegistration(LocalDate dateOfRegistration) { builder.dateOfRegistration(dateOfRegistration); }

    public void setDateOfEnd(LocalDate dateOfEnd) { builder.dateOfEnd(dateOfEnd); }


    /* stupid way to solve problems using the checkbox */
    //TODO: get rid of the silly way and do fine
    @Override
    public FullDaySubscription create() {
        client = builder.build();
        isCreated = true;
        return this;
    }

    @Override
    public User getUser() {
        created();
        return client.getUser();
    }

    @Override
    public LocalDate getDateOfRegistration() {
        created();
        return client.getDateOfRegistration();
    }

    @Override
    public LocalTime getTimeFrom() {
        created();
        return client.getTimeFrom();
    }

    @Override
    public LocalTime getTimeUntil() {
        created();
        return client.getTimeUntil();
    }

    @Override
    public EnumSet<FitnessServices> getAccessServices() {
        created();
        return accessServices;
    }

    @Override
    public LocalDate getDateOfEnd() {
        created();
        return client.getDateOfEnd();
    }

    private void created() { if (!isCreated) create(); }
}