package com.ttasjwi.lecture.step02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {

    private String title;
    private int pass;
    private final List<Integer> scores = new ArrayList<>();

    public Lecture(String title, int pass, List<Integer> scores) {
        this.title = title;
        this.pass = pass;
        this.scores.addAll(scores);
    }

    /**
     * 메서드 오버로딩 : 부모의 average와 시그니처가 다름
     */
    public double average() {
        return scores.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(0);
    }

    public List<Integer> getScores() {
        return Collections.unmodifiableList(scores);
    }

    public String evaluate() {
        return String.format("Pass:%d Fail:%d", passCount(), failCount());
    }

    private long passCount() {
        return scores.stream()
                .filter(score -> score >= pass)
                .count();
    }

    private long failCount() {
        return scores.size() - passCount();
    }

    public String stats() {
        return String.format("Title: %s, Evaluation Method: %s", title, getEvaluationMethod());
    }

    public String getEvaluationMethod() {
        return "Pass or Fail";
    }
}
