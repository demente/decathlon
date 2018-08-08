package com.kn.decathlon.constants;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DisciplineTest {

    @Test
    public void considersHighJumpJumping() {
        assertThat(Discipline.HIGH_JUMP.isJumping()).isTrue();
    }

    @Test
    public void considersLongJumpJumping() {
        assertThat(Discipline.LONG_JUMP.isJumping()).isTrue();
    }

    @Test
    public void considersPoleVaultJumping() {
        assertThat(Discipline.POLE_VAULT.isJumping()).isTrue();
    }

}