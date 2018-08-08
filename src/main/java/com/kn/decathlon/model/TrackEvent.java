package com.kn.decathlon.model;

import com.kn.decathlon.constants.Discipline;

public class TrackEvent implements Event {

    private Discipline discipline;
    private double timeInSeconds;

    public TrackEvent(Discipline discipline, double timeInSeconds) {
        this.discipline = discipline;
        this.timeInSeconds = timeInSeconds;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public double getTimeInSeconds() {
        return timeInSeconds;
    }

    public void setTimeInSeconds(double timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
    }

    public Integer getScore() {
        return (int) (discipline.getA() * Math.pow(discipline.getB() - timeInSeconds, discipline.getC()));
    }
}
