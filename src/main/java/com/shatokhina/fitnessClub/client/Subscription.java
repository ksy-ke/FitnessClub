package com.shatokhina.fitnessClub.client;

import com.shatokhina.fitnessClub.FitnessServices;
import com.shatokhina.fitnessClub.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.EnumSet;

public interface Subscription {
    Subscription create();

    User getUser();

    LocalDate getDateOfRegistration();

    LocalTime getTimeFrom();

    LocalTime getTimeUntil();

    EnumSet<FitnessServices> getAccessServices();

    LocalDate getDateOfEnd();
}