package com.kn.decathlon.model;

import com.kn.decathlon.constants.Discipline;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrackEventTest {

    @Test
    public void calculatesPoints() {
        TrackEvent trackEvent = new TrackEvent(Discipline.HUNDRED_METER, 12.12);

        assertThat(trackEvent.getScore()).isEqualTo(628);
    }

}