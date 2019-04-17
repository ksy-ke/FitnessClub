package com.shatokhina.fitnessClub.subscription;

import java.util.EnumSet;
import java.util.function.UnaryOperator;

import static com.shatokhina.fitnessClub.FitnessService.GYM;
import static com.shatokhina.fitnessClub.FitnessService.POOL;

public interface OneTimeSubscriptionFactory extends SubscriptionFactory {
    static OneTimeSubscriptionFactory newInstance() {
        return new SubscriptionFactoryImpl("One time subscription", EnumSet.of(GYM, POOL), UnaryOperator.identity());
    }
}