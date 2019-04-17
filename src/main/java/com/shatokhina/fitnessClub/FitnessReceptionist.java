package com.shatokhina.fitnessClub;

import com.shatokhina.fitnessClub.exceptions.NoAccessException;
import com.shatokhina.fitnessClub.exceptions.QueueException;
import com.shatokhina.fitnessClub.subscription.Subscription;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

import static com.shatokhina.fitnessClub.FitnessService.*;

public class FitnessReceptionist {
    private final static FitnessReceptionist RECEPTIONIST = new FitnessReceptionist();
    private Map<User, FitnessService> clientsNow = new HashMap<>();
    private Map<FitnessService, Set<User>> peopleInClass = new HashMap<>();

    private FitnessReceptionist() {
        peopleInClass.put(GYM, new HashSet<>());
        peopleInClass.put(POOL, new HashSet<>());
        peopleInClass.put(GROUP, new HashSet<>());
    }

    public void markPresent(User user, FitnessService service) throws QueueException, NoAccessException {
        var subscription = user.getSubscription().orElseThrow(() -> new NoAccessException("No subscription"));
        if (!isCanBeHere(subscription, service)) throw new NoAccessException("Now there is no access");
        if (!peopleInClass.isEmpty() && peopleInClass.get(service).size() >= 20)
            throw new QueueException("Maximum number of people engaged in the " + service);
        clientsNow.put(user, service);
        peopleInClass.get(service).add(user);
    }

    public void markDeparture(User user) {
        Optional.ofNullable(clientsNow.get(user)).ifPresent(serv -> peopleInClass.get(serv).remove(user));
    }

    public void printPeopleInClass() {
        Comparator<User> sort = Comparator.comparing(User::getSurname).thenComparing(User::getName);

        List<User> peopleInGym = new ArrayList<>(peopleInClass.get(GYM));
        List<User> peopleInPool = new ArrayList<>(peopleInClass.get(POOL));
        List<User> peopleInGroup = new ArrayList<>(peopleInClass.get(GROUP));
        peopleInGym.sort(sort);
        peopleInPool.sort(sort);
        peopleInGroup.sort(sort);

        peopleInGym.forEach(user -> System.out.println(user.toString() + " <" + GYM + '>'));
        peopleInPool.forEach(user -> System.out.println(user.toString() + " <" + POOL + '>'));
        peopleInGroup.forEach(user -> System.out.println(user.toString() + " <" + GROUP + '>'));
    }

    public static FitnessReceptionist getReceptionist() { return RECEPTIONIST; }

    private boolean isCanBeHere(Subscription subscription, FitnessService service) {
        return subscription.getFitnessServices().stream().anyMatch(serv -> serv.equals(service)) &&
                subscription.getDateOfEnd().isAfter(LocalDate.now().minusDays(1)) && //TODO: need create method with check user subscription
                subscription.getDateOfRegistration().isBefore(LocalDate.now().plusDays(1)) &&
                subscription.getTimeFrom().isBefore(LocalTime.now()) &&
                subscription.getTimeUntil().isAfter(LocalTime.now());
    }
}