package com.kn.decathlon.builder;

import com.kn.decathlon.constants.Discipline;
import com.kn.decathlon.model.TrackEvent;

public class TrackEventBuilder {

    private Discipline discipline;
    private double timeInSeconds;

    private TrackEventBuilder() {

    }

    public static TrackEventBuilder aTrackEvent() {
        return new TrackEventBuilder()
                .withDiscipline(Discipline.HUNDRED_METER)
                .withTime(10.395);
    }

    public TrackEventBuilder withDiscipline(Discipline discipline) {
        this.discipline = discipline;
        return this;
    }

    public TrackEventBuilder withTime(double timeInSeconds) {
        this.timeInSeconds = timeInSeconds;
        return this;
    }

    public TrackEvent build() {
        return new TrackEvent(discipline, timeInSeconds);
    }

}
