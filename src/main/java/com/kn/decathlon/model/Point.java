package com.kn.decathlon.model;

import com.kn.decathlon.constants.Discipline;

public class Point {

    private Discipline discipline;
    private Long distanceInCm;
    private Long timeInSeconds;

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Long getDistanceInCm() {
        return distanceInCm;
    }

    public void setDistanceInCm(Long distanceInCm) {
        this.distanceInCm = distanceInCm;
    }

    public Long getTimeInSeconds() {
        return timeInSeconds;
    }

    public void setTimeInSeconds(Long timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }
}
