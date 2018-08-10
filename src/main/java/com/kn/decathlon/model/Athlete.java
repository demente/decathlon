package com.kn.decathlon.model;

import java.util.List;

import static com.kn.decathlon.utils.CalculationUtils.getNumberOfAthletesWithTotalScoreEqualTo;
import static com.kn.decathlon.utils.CalculationUtils.getNumberOfAthletesWithTotalScoreHigherThan;

public class Athlete {

    private String name;
    private List<Event> events;

    public Athlete(String name, List<Event> events) {
        this.name = name;
        this.events = events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public Integer getTotalScore() {
        return getEvents().stream().mapToInt(Event::getScore).sum();
    }

    public String calculatePlace(List<Athlete> athletes) {
        Long withBetterResult = getNumberOfAthletesWithTotalScoreHigherThan(getTotalScore(), athletes);
        Long withSameResult = getNumberOfAthletesWithTotalScoreEqualTo(getTotalScore(), athletes);

        if (withSameResult > 1) {
            return (withBetterResult + 1) + "-" + (withBetterResult + withSameResult);
        }
        return String.valueOf(withBetterResult + 1);
    }
}
