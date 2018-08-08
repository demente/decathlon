package com.kn.decathlon.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class AthleteTest {

    @Mock
    private FieldEvent fieldEvent;
    @Mock
    private TrackEvent trackEvent;

    @Test
    public void calculatesTotalScore() {
        given(fieldEvent.getScore()).willReturn(20);
        given(trackEvent.getScore()).willReturn(30);

        Athlete athlete = new Athlete("Test name", asList(fieldEvent, trackEvent));

        Integer totalScore = athlete.getTotalScore();

        assertThat(totalScore).isEqualTo(50);
    }

}