package com.kn.decathlon.model;

import com.kn.decathlon.constants.Discipline;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FieldEventTest {

    @Test
    public void calculatesScoreForJumpingEvent() {
        FieldEvent fieldEvent = new FieldEvent(Discipline.HIGH_JUMP, 188);

        assertThat(fieldEvent.getScore()).isEqualTo(696);
    }

    @Test
    public void calculatesScoreForThrowingEvent() {
        FieldEvent fieldEvent = new FieldEvent(Discipline.JAVELIN_THROW, 57.45);

        assertThat(fieldEvent.getScore()).isEqualTo(628);
    }

}