package com.kn.decathlon.service;

import com.kn.decathlon.model.Athlete;
import com.kn.decathlon.model.Event;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static com.kn.decathlon.constants.Discipline.DISCUS_THROW;
import static com.kn.decathlon.constants.Discipline.FOUR_HUNDRED_METER;
import static com.kn.decathlon.constants.Discipline.HIGH_JUMP;
import static com.kn.decathlon.constants.Discipline.HUNDRED_METER;
import static com.kn.decathlon.constants.Discipline.HURDLES;
import static com.kn.decathlon.constants.Discipline.JAVELIN_THROW;
import static com.kn.decathlon.constants.Discipline.LONG_JUMP;
import static com.kn.decathlon.constants.Discipline.POLE_VAULT;
import static com.kn.decathlon.constants.Discipline.SHOT_PUT;
import static com.kn.decathlon.constants.Discipline.THOUSAND_FIVE_HUNDRED;
import static org.assertj.core.api.Assertions.assertThat;

public class CsvFileReaderTest {

    private CsvFileReader csvFileReader = new CsvFileReader();

    @Test
    public void parsesCsvIntoAthleteList() throws FileNotFoundException {
        List<Athlete> athletes = csvFileReader.read("results.csv");

        assertThat(athletes).extracting(Athlete::getName).containsExactly("Test name");
        assertThat(athletes).flatExtracting(Athlete::getEvents)
                            .extracting(Event::getDiscipline)
                            .containsExactly(HUNDRED_METER,
                                             LONG_JUMP,
                                             SHOT_PUT,
                                             HIGH_JUMP,
                                             FOUR_HUNDRED_METER,
                                             HURDLES,
                                             DISCUS_THROW,
                                             POLE_VAULT,
                                             JAVELIN_THROW,
                                             THOUSAND_FIVE_HUNDRED);

        assertThat(athletes).flatExtracting(Athlete::getEvents)
                            .extracting(Event::getValue)
                            .containsExactly(10.23, 7.88, 14.52, 2.01, 45.0, 13.69, 43.34, 5.2, 63.63, 257.52);
    }

}