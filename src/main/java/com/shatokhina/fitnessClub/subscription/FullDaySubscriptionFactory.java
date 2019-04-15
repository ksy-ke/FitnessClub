package com.shatokhina.fitnessClub.subscription;

import com.shatokhina.fitnessClub.FitnessService;
import com.shatokhina.fitnessClub.User;

import java.util.EnumSet;

public interface FullDaySubscriptionFactory extends SubscriptionFactory {
    void setExpiringAfter(int numberOfMonths);

    static FullDaySubscriptionFactory newInstance(User user) {
        return new SubscriptionFactoryImpl(user,
                EnumSet.allOf(FitnessService.class),
                registration -> registration.plusMonths(12));
    }
}