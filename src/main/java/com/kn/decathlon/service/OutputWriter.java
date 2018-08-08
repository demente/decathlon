package com.kn.decathlon.service;

import java.io.IOException;

public interface OutputWriter {

    void writeOutput(String content, String destination) throws IOException;

}
