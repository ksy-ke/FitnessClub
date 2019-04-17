package com.shatokhina.fitnessClub.subscription;

import com.shatokhina.fitnessClub.FitnessService;

import java.util.EnumSet;

public interface FullDaySubscriptionFactory extends SubscriptionFactory {
    void setExpiringAfter(int numberOfMonths);

    static FullDaySubscriptionFactory newInstance() {
        return new SubscriptionFactoryImpl("Full day subscription", EnumSet.allOf(FitnessService.class),
                registration -> registration.plusMonths(12));
    }
}