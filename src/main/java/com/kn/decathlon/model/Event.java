package com.kn.decathlon.model;

import com.kn.decathlon.constants.Discipline;

public interface Event {

    Integer getScore();

    Discipline getDiscipline();

    double getValue();
}
