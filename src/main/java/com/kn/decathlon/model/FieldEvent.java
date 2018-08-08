package com.kn.decathlon.model;

import com.kn.decathlon.constants.Discipline;

public class FieldEvent implements Event {

    private Discipline discipline;
    private double distanceInCm;

    public FieldEvent(Discipline discipline, double distanceInCm) {
        this.discipline = discipline;
        this.distanceInCm = distanceInCm;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public double getDistanceInCm() {
        return distanceInCm;
    }

    public void setDistanceInCm(double distanceInCm) {
        this.distanceInCm = distanceInCm;
    }

    public Integer getScore() {
        if (discipline.isJumping()) {
            return (int) (discipline.getA() * Math.pow(distanceInCm - discipline.getB(), discipline.getC()));
        }
        return (int) (discipline.getA() * Math.pow(distanceInCm / 100 - discipline.getB(), discipline.getC()));
    }

}
