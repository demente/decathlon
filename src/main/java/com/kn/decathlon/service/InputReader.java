package com.kn.decathlon.service;

import com.kn.decathlon.model.Athlete;

import java.io.FileNotFoundException;
import java.util.List;

public interface InputReader {

    List<Athlete> read(String source) throws FileNotFoundException;
}
