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
    @Mock
    private Athlete firstAthlete;
    @Mock
    private Athlete secondAthlete;
    @Mock
    private Athlete thirdAthlete;

    @Test
    public void calculatesTotalScore() {
        given(fieldEvent.getScore()).willReturn(20);
        given(trackEvent.getScore()).willReturn(30);

        Athlete athlete = new Athlete("Test name", asList(fieldEvent, trackEvent));

        Integer totalScore = athlete.getTotalScore();

        assertThat(totalScore).isEqualTo(50);
    }

    @Test
    public void returnsPlaceAsRangeFromFirstPlace() {
        given(fieldEvent.getScore()).willReturn(500);
        given(trackEvent.getScore()).willReturn(500);

        given(firstAthlete.getTotalScore()).willReturn(100);
        given(secondAthlete.getTotalScore()).willReturn(1000);
        given(thirdAthlete.getTotalScore()).willReturn(1000);

        Athlete athlete = new Athlete("Test name", asList(fieldEvent, trackEvent));

        String actual = athlete.calculatePlace(asList(athlete, firstAthlete, secondAthlete, thirdAthlete));

        assertThat(actual).isEqualTo("1-3");
    }

    @Test
    public void returnsPlaceAsRange() {
        given(fieldEvent.getScore()).willReturn(500);
        given(trackEvent.getScore()).willReturn(500);

        given(firstAthlete.getTotalScore()).willReturn(1000);
        given(secondAthlete.getTotalScore()).willReturn(1001);
        given(thirdAthlete.getTotalScore()).willReturn(1000);

        Athlete athlete = new Athlete("Test name", asList(fieldEvent, trackEvent));

        String actual = athlete.calculatePlace(asList(athlete, firstAthlete, secondAthlete, thirdAthlete));

        assertThat(actual).isEqualTo("2-4");
    }

    @Test
    public void returnsPlaceAsSingleNumber() {
        given(fieldEvent.getScore()).willReturn(500);
        given(trackEvent.getScore()).willReturn(400);

        given(firstAthlete.getTotalScore()).willReturn(1000);
        given(secondAthlete.getTotalScore()).willReturn(1001);
        given(thirdAthlete.getTotalScore()).willReturn(1000);

        Athlete athlete = new Athlete("Test name", asList(fieldEvent, trackEvent));

        String actual = athlete.calculatePlace(asList(athlete, firstAthlete, secondAthlete, thirdAthlete));

        assertThat(actual).isEqualTo("4");
    }

}