package com.kn.decathlon.constants;

public enum Discipline {

    HUNDRED_METER(25.4347, 18, 1.81),
    LONG_JUMP(0.14354, 220, 1.4),
    SHOT_PUT(51.39, 1.5, 1.05),
    HIGH_JUMP(0.8465, 75, 1.42),
    FOUR_HUNDRED_METER(1.53775, 82, 1.81),
    HURDLES(5.74352, 28.5, 1.92),
    DISCUS_THROW(12.91, 4, 1.1),
    POLE_VAULT(0.2797, 100, 1.35),
    JAVELIN_THROW(10.14, 7, 1.08),
    THOUSAND_FIVE_HUNDRED(0.03768, 480, 1.85);

    private double a;
    private double b;
    private double c;

    Discipline(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public boolean isJumping() {
        return this == Discipline.HIGH_JUMP || this == Discipline.LONG_JUMP ||
               this == Discipline.POLE_VAULT;
    }
}
