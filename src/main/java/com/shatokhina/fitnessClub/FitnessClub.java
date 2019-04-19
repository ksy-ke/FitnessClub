package com.shatokhina.fitnessClub;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FitnessClub {
    private Set<User> allUsers = new HashSet<>();

    public void open() { validation(); }


    public void registration(User user) { allUsers.add(user); }

    private void validation() {
        allUsers = allUsers.stream().map(User::validationOfSubscription).collect(Collectors.toSet());
    }
}