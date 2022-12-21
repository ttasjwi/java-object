package com.ttasjwi.lecture.step02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GradeLectureTest {

    @Test
    public void thisTest() {
        Lecture lecture = createGradeLecture();

        String stats = lecture.stats();
        System.out.println(stats);

        /**
         * 메서드의 this 키워드는 해당 클래스를 호출하는 것이 아닌,
         * 호출된 객체의 self 참조를 다시 탐색하는 지시어다.
         *
         * -> 내부적으로 GradeLecture 인스턴스의 stats 메서드에서 this.getEvaluation()이 호출되더라도,
         * self 참조를 얻어 다시 그 위치에서부터 메서드를 탐색한다.
         * -> self 참조가 동적인 문맥을 결정한다.
         */
        assertThat(stats).isEqualTo("Title: 객체지향 프로그래밍, Evaluation Method: Grade");
    }

    public void exception() {
        Lecture lecture = createGradeLecture();
        // lecture.unknownMessage();
        // 컴파일 에러 : self가 가리키는 객체의 class 참조를 통해 상속 계층을 따라가서 메시지를 처리할 수 있는 메서드가 없으므로 예외 발생
    }

    private static GradeLecture createGradeLecture() {
        return new GradeLecture(
                "객체지향 프로그래밍", 70,
                Arrays.asList(81, 95, 75, 50, 45),
                Arrays.asList(
                        new Grade("A", 100, 95),
                        new Grade("B", 94, 80),
                        new Grade("C", 79, 70),
                        new Grade("D", 69, 50),
                        new Grade("F", 49, 0)));
    }
}
