package com.kn.decathlon.service;

import org.junit.After;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterTest {

    private FileWriter fileWriter = new FileWriter();

    @Test()
    public void createsXmlFileWithResult() throws IOException {
        fileWriter.writeOutput("my file", "result.xml");
    }

    @After
    public void cleanup() throws IOException {
        Files.delete(Paths.get("result.xml"));
    }

}