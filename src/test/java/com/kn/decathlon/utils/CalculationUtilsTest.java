package com.kn.decathlon.utils;

import com.kn.decathlon.model.Athlete;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CalculationUtilsTest {

    @Mock
    private Athlete firstAthlete;
    @Mock
    private Athlete secondAthlete;
    @Mock
    private Athlete thirdAthlete;

    @Test
    public void returnsNumberOfAthletesWithTotalScoreHigherThanGivenScore() {
        given(firstAthlete.getTotalScore()).willReturn(2000);
        given(secondAthlete.getTotalScore()).willReturn(1001);
        given(thirdAthlete.getTotalScore()).willReturn(1000);

        Long actual = CalculationUtils.getNumberOfAthletesWithTotalScoreHigherThan(1000, asList(firstAthlete, secondAthlete, thirdAthlete));

        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void returnsNumberOfAthletesWithTotalScoreEqualToGivenScore() {
        given(firstAthlete.getTotalScore()).willReturn(1000);
        given(secondAthlete.getTotalScore()).willReturn(1001);
        given(thirdAthlete.getTotalScore()).willReturn(1000);

        Long actual = CalculationUtils.getNumberOfAthletesWithTotalScoreEqualTo(1000, asList(firstAthlete, secondAthlete, thirdAthlete));

        assertThat(actual).isEqualTo(2);
    }

}