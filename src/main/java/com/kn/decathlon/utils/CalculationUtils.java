package com.kn.decathlon.utils;

import com.kn.decathlon.model.Athlete;

import java.util.List;

public class CalculationUtils {

    public static Long getNumberOfAthletesWithTotalScoreHigherThan(double totalScore, List<Athlete> athletes) {
        return athletes.stream().filter(athlete -> athlete.getTotalScore() > totalScore).count();
    }

    public static Long getNumberOfAthletesWithTotalScoreEqualTo(double totalScore, List<Athlete> athletes) {
        return athletes.stream().filter(athlete -> athlete.getTotalScore() == totalScore).count();
    }

}
