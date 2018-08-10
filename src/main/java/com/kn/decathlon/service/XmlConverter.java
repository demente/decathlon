package com.kn.decathlon.service;

import com.kn.decathlon.model.Athlete;
import com.kn.decathlon.model.Event;

import java.util.Comparator;
import java.util.List;

public class XmlConverter {

    public String toXml(List<Athlete> athleteList) {
        StringBuilder builder = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

        builder.append("<athletes>");

        athleteList.sort(Comparator.comparing(Athlete::getTotalScore));

        athleteList.forEach(athlete -> builder.append(getAthleteAsXml(athlete, athleteList)));

        builder.append("</athletes>");

        return builder.toString();
    }

    private String getAthleteAsXml(Athlete athlete, List<Athlete> athleteList) {
        StringBuilder builder = new StringBuilder("<athelete>");

        builder.append("<name>" + athlete.getName() + "</name>");
        builder.append("<totalScore>" + athlete.getTotalScore() + "</totalScore>");
        builder.append("<place>" + athlete.calculatePlace(athleteList) + "</place>");

        builder.append("<results>");
        athlete.getEvents().forEach(event -> builder.append(getResultAsXml(event)));
        builder.append("</results>");

        builder.append("</athlete>");
        return builder.toString();
    }

    private String getResultAsXml(Event event) {
        StringBuilder builder = new StringBuilder("<result>");

        builder.append("<discipline>" + event.getDiscipline() + "</discipline>");
        builder.append("<value>" + event.getValue() + "</value>");

        builder.append("</result>");
        return builder.toString();
    }

}
