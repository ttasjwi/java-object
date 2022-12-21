package com.ttasjwi.lecture.step02;

import java.util.List;

public class FormattedGradeLecture extends GradeLecture {

    public FormattedGradeLecture(String title, int pass, List<Integer> scores, List<Grade> grades) {
        super(title, pass, scores, grades);
    }

    /**
     * super 키워드는 '이 클래스의 부모 클래스에서부터 메서드를 탐색하라'는 의미이다.
     *
     * self 키워드는 가리키는 객체가 동적으로 정해지지만, super 키워드의 경우, 항상 메시지를 전송하는 클래스의 부모 클래스에서 시작된다.
     */
    public String formatAverage() {
        return String.format("Avg: %1.1f", super.average());
    }
}
