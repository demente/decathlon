package com.kn.decathlon.service;

import com.kn.decathlon.model.Athlete;
import org.junit.Test;

import static com.kn.decathlon.builder.AthleteBuilder.anAthlete;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class XmlConverterTest {

    private XmlConverter xmlConverter = new XmlConverter();

    @Test
    public void convertsAthletesToXml() {
        Athlete athlete = anAthlete().build();

        String convertedAthleteList = xmlConverter.toXml(asList(athlete, athlete));

        String s = athlete.calculatePlace(asList(athlete, athlete));

        assertThat(convertedAthleteList).isEqualTo("<?xml version=\"1.0\" encoding=\"UTF-8\"?><athletes><athelete><name>Test name</name><totalScore>1000</totalScore><place>1-2</place><results><result><discipline>LONG_JUMP</discipline><value>7.76</value></result><result><discipline>HUNDRED_METER</discipline><value>10.395</value></result></results></athlete><athelete><name>Test name</name><totalScore>1000</totalScore><place>1-2</place><results><result><discipline>LONG_JUMP</discipline><value>7.76</value></result><result><discipline>HUNDRED_METER</discipline><value>10.395</value></result></results></athlete></athletes>");
    }

}