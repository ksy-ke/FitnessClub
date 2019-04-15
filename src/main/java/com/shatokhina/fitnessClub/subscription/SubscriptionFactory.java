package com.shatokhina.fitnessClub.subscription;

import java.time.LocalDate;

interface SubscriptionFactory {
    void setRegistered(LocalDate registrationDate);

    Subscription create();
}
