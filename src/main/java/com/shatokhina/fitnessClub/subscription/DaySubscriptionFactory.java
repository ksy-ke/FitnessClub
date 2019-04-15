package com.shatokhina.fitnessClub.subscription;

import com.shatokhina.fitnessClub.User;

import java.time.LocalTime;
import java.util.EnumSet;

import static com.shatokhina.fitnessClub.FitnessService.GROUP;
import static com.shatokhina.fitnessClub.FitnessService.GYM;

public interface DaySubscriptionFactory extends SubscriptionFactory {
    void setExpiringAfter(int numberOfMonths);

    static DaySubscriptionFactory newInstance(User user) {
        var factory = new SubscriptionFactoryImpl(user, EnumSet.of(GYM, GROUP), registration -> registration.plusMonths(12));
        factory.setVisitsUntil(LocalTime.of(16, 0));
        return factory;
    }
}