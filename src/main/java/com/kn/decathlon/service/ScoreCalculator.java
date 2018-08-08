package com.kn.decathlon.service;

import com.kn.decathlon.model.Athlete;
import com.kn.decathlon.model.Event;

public class ScoreCalculator {

    public Integer calculateTotalScore(Athlete athlete) {
        return athlete.getEvents().stream().mapToInt(Event::getScore).sum();
    }

}
