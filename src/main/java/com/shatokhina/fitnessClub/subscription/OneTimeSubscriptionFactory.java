package com.shatokhina.fitnessClub.subscription;

import com.shatokhina.fitnessClub.User;

import java.util.EnumSet;
import java.util.function.UnaryOperator;

import static com.shatokhina.fitnessClub.FitnessService.GYM;
import static com.shatokhina.fitnessClub.FitnessService.POOL;

public interface OneTimeSubscriptionFactory extends SubscriptionFactory {
    static OneTimeSubscriptionFactory newInstance(User user) {
        return new SubscriptionFactoryImpl(user, EnumSet.of(GYM, POOL), UnaryOperator.identity());
    }
}