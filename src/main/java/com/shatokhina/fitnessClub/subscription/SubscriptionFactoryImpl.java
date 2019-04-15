package com.shatokhina.fitnessClub.subscription;

import com.shatokhina.fitnessClub.FitnessService;
import com.shatokhina.fitnessClub.User;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.EnumSet;
import java.util.function.UnaryOperator;

import static java.time.LocalDate.now;

public final class SubscriptionFactoryImpl implements OneTimeSubscriptionFactory, DaySubscriptionFactory, FullDaySubscriptionFactory {
    private static final LocalTime DEFAULT_UNTIL = LocalTime.of(22, 0);

    private UnaryOperator<LocalDate> endTimeCalculation;
    private final User user;
    private final EnumSet<FitnessService> services;
    private LocalDate registeredDate;
    private LocalTime visitsUntil;

    SubscriptionFactoryImpl(User user, EnumSet<FitnessService> services, UnaryOperator<LocalDate> endTimeCalculation) {
        this.user = user;
        this.services = services;
        this.endTimeCalculation = endTimeCalculation;
    }

    public void setRegistered(LocalDate registeredDate) { this.registeredDate = registeredDate; }

    public void setExpiringAfter(int months) { endTimeCalculation = registrationDate -> registrationDate.plusMonths(months); }

    void setVisitsUntil(LocalTime value) { this.visitsUntil = value; }

    public Subscription create() {
        var registration = registeredDate != null ? registeredDate : now();

        return new Subscription(
                user,
                services,
                registration,
                visitsUntil != null ? visitsUntil : DEFAULT_UNTIL,
                endTimeCalculation.apply(registration)
        );
    }
}