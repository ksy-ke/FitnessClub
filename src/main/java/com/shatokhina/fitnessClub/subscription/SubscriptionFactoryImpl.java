package com.shatokhina.fitnessClub.subscription;

import com.shatokhina.fitnessClub.FitnessService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.EnumSet;
import java.util.function.UnaryOperator;

import static java.time.LocalDate.now;

public final class SubscriptionFactoryImpl implements OneTimeSubscriptionFactory, DaySubscriptionFactory, FullDaySubscriptionFactory {
    private static final LocalTime DEFAULT_UNTIL = LocalTime.of(22, 0);

    private final EnumSet<FitnessService> services;
    private UnaryOperator<LocalDate> endTimeCalculation;
    private LocalDate registeredDate;
    private LocalTime visitsUntil;
    private String type;

    SubscriptionFactoryImpl(String type, EnumSet<FitnessService> services, UnaryOperator<LocalDate> endTimeCalculation) {
        this.services = services;
        this.endTimeCalculation = endTimeCalculation;
        this.type = type;
    }

    public void setRegistered(LocalDate registeredDate) { this.registeredDate = registeredDate; }

    public void setExpiringAfter(int months) { endTimeCalculation = registrationDate -> registrationDate.plusMonths(months); }

    void setVisitsUntil(LocalTime value) { this.visitsUntil = value; }

    public Subscription create() {
        var registration = registeredDate != null ? registeredDate : now();

        return new Subscription(
                type,
                services,
                registration,
                visitsUntil != null ? visitsUntil : DEFAULT_UNTIL,
                endTimeCalculation.apply(registration)
        );
    }
}