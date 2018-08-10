package com.kn.decathlon.service;

import com.kn.decathlon.constants.Discipline;
import com.kn.decathlon.model.Athlete;
import com.kn.decathlon.model.Event;
import com.kn.decathlon.model.FieldEvent;
import com.kn.decathlon.model.TrackEvent;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;

public class CsvFileReader implements InputReader {

    @Override
    public List<Athlete> read(String source) throws FileNotFoundException {

        List<Athlete> athletes = new ArrayList<>();
        Scanner in = new Scanner(Thread.currentThread().getContextClassLoader().getResourceAsStream(source));
        while (in.hasNextLine()) {
            athletes.add(convertToAthlete(in.nextLine()));
        }
        return athletes;
    }

    private Athlete convertToAthlete(String line) {
        String[] split = line.split(";");

        List<Event> events = asList(
                new TrackEvent(Discipline.HUNDRED_METER, Double.valueOf(split[1])),
                new FieldEvent(Discipline.LONG_JUMP, Double.valueOf(split[2])),
                new FieldEvent(Discipline.SHOT_PUT, Double.valueOf(split[3])),
                new FieldEvent(Discipline.HIGH_JUMP, Double.valueOf(split[4])),
                new TrackEvent(Discipline.FOUR_HUNDRED_METER, Double.valueOf(split[5])),
                new TrackEvent(Discipline.HURDLES, Double.valueOf(split[6])),
                new FieldEvent(Discipline.DISCUS_THROW, Double.valueOf(split[7])),
                new FieldEvent(Discipline.POLE_VAULT, Double.valueOf(split[8])),
                new FieldEvent(Discipline.JAVELIN_THROW, Double.valueOf(split[9])),
                new TrackEvent(Discipline.THOUSAND_FIVE_HUNDRED, convertToSeconds(split[10])));

        return new Athlete(split[0], events);
    }

    private double convertToSeconds(String value) {
        int minuteSeparatorIndex = value.indexOf(".");
        return Integer.valueOf(value.substring(0, minuteSeparatorIndex)) * 60 +
               Double.valueOf(value.substring(minuteSeparatorIndex+1));
    }

}
