package com.ttasjwi.variance;

public class MegazineStore extends BookStall {

    @Override
    public Book sell(IndependentPublisher independentPublisher) {
        // 리턴타입 공변성 : 부모 클래스에서 구현된 메서드를 자식 클래스에서 오버라이딩할 때,
        // 부모 클래스에서 선언한 반환 타입의 서브타입으로 지정할 수 있는 특성
        // (참고) 자바는 리턴타입 공변성을 지원하지만 C#은 리턴타입 공변성을 지원하지 않는다.
        return new Megazine(independentPublisher);
    }
}
