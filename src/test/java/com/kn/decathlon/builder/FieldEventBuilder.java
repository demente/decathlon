package com.kn.decathlon.builder;

import com.kn.decathlon.constants.Discipline;
import com.kn.decathlon.model.FieldEvent;

public class FieldEventBuilder {

    private Discipline discipline;
    private double distanceInCm;

    private FieldEventBuilder() {

    }

    public static FieldEventBuilder aFieldEvent() {
        return new FieldEventBuilder()
                .withDiscipline(Discipline.LONG_JUMP)
                .withDistance(7.76);
    }

    public FieldEventBuilder withDiscipline(Discipline discipline) {
        this.discipline = discipline;
        return this;
    }

    public FieldEventBuilder withDistance(double distanceInCm) {
        this.distanceInCm = distanceInCm;
        return this;
    }

    public FieldEvent build() {
        return new FieldEvent(discipline, distanceInCm);
    }

}
