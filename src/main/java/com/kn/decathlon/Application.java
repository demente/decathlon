package com.kn.decathlon;

import com.kn.decathlon.model.Athlete;
import com.kn.decathlon.service.CsvFileReader;
import com.kn.decathlon.service.FileWriter;
import com.kn.decathlon.service.XmlConverter;

import java.io.IOException;
import java.util.List;

public class Application {

    private static XmlConverter xmlConverter = new XmlConverter();
    private static CsvFileReader reader = new CsvFileReader();
    private static FileWriter fileWriter = new FileWriter();

    public static void main(String[] argz) throws IOException {
        List<Athlete> athleteList = reader.read("results.csv");
        fileWriter.writeOutput(xmlConverter.toXml(athleteList), "result.xml");
    }

}
