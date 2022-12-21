package com.ttasjwi.lecture.step01;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LectureTest {

    @Test
    public void lectureTest() {
        Lecture lecture = new Lecture("객체지향 프로그래밍", 70, Arrays.asList(81, 95, 75, 50, 45));
        String evaluation = lecture.evaluate();
        System.out.println(evaluation);
        assertThat(evaluation).isEqualTo("Pass:3 Fail:2");
    }

}
