package com.ttasjwi.lecture.step02;

public class Professor {

    private String name;
    private Lecture lecture;

    public Professor(String name, Lecture lecture) {
        this.name = name;
        this.lecture = lecture;
    }

    public String compileStatistics() {
        return String.format("[%s] %s - Arg: %.1f",
                name, lecture.evaluate(), lecture.average());
    }
}
