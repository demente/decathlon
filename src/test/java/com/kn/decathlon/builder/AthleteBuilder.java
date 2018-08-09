package com.kn.decathlon.builder;

import com.kn.decathlon.model.Athlete;
import com.kn.decathlon.model.Event;

import java.util.List;

import static com.kn.decathlon.builder.FieldEventBuilder.aFieldEvent;
import static com.kn.decathlon.builder.TrackEventBuilder.aTrackEvent;
import static java.util.Arrays.asList;

public class AthleteBuilder {

    private String name;
    private List<Event> events;

    private AthleteBuilder() {

    }

    public static AthleteBuilder anAthlete() {
        return new AthleteBuilder().withName("Test name")
                                   .withEvents(asList(aFieldEvent().build(), aTrackEvent().build()));
    }

    public AthleteBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public AthleteBuilder withEvents(List<Event> events) {
        this.events = events;
        return this;
    }

    public Athlete build() {
        return new Athlete(name, events);
    }

}
