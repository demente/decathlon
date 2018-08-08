package com.kn.decathlon.service;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter implements OutputWriter {

    @Override
    public void writeOutput(String content, String destination) throws IOException {
        FileOutputStream out = new FileOutputStream(destination);
        out.write(content.getBytes());
        out.close();
    }
}
