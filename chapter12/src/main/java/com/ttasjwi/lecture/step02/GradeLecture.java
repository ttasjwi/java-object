package com.ttasjwi.lecture.step02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GradeLecture extends Lecture {

    private final List<Grade> grades = new ArrayList<>();

    public GradeLecture(String title, int pass, List<Integer> scores, List<Grade> grades) {
        super(title, pass, scores);
        this.grades.addAll(grades);
    }

    @Override
    public String evaluate() {
        return super.evaluate() + ", " + gradesStatistics();
    }

    private String gradesStatistics() {
        return grades.stream()
                .map(grade -> format(grade))
                .collect(Collectors.joining(" "));
    }

    private String format(Grade grade) {
        return String.format("%s:%d", grade.getName(), gradeCount(grade));
    }

    private long gradeCount(Grade grade) {
        return getScores().stream()
                .filter(grade::include)
                .count();
    }

    /**
     * 등급 이름을 통해 해당 등급의 성적을 반환
     */
    public double average(String gradeName) {
        return grades.stream()
                .filter(grade -> grade.isName(gradeName))
                .findFirst()
                .map(this::gradeAverage)
                .orElse(0d);
    }

    private double gradeAverage(Grade grade) {
        return getScores().stream()
                .filter(grade::include)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    @Override
    public String getEvaluationMethod() {
        return "Grade";
    }
}
