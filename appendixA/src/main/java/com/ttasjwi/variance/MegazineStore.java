package com.ttasjwi.variance;

public class MegazineStore extends BookStall {


    //public Book sell(Publisher publisher) {
    // 서브타입의 메서드에서 파라미터 타입이 슈퍼타입으로 되어 있더라도 실제 런타임에는 슈퍼타입이 주입될 것이며, 협력은 정상적으로 돌아간다.

    // 파라미터 타입 반공변성 : 부모 클래스에서 구현된 메서드를 자식 클래스에서 오버라이딩할 때 파라미터 타입을 부모 클래스에서 사용한 파라미터의
    // 슈퍼타입으로 대체할 수 있는 특성
    // 더 약한 사전조건을 정의하는 것과 같으므로 계약에 의한 설계 관점에서 계약을 위반하지 않고, 리스코프 치환 원칙을 위배하지 않는다.
    // 하지만 자바에서는 파라미터 타입 반공변성을 지원하지 않는다.


    @Override
    public Book sell(IndependentPublisher independentPublisher) {
        // 리턴타입 공변성 : 부모 클래스에서 구현된 메서드를 자식 클래스에서 오버라이딩할 때,
        // 부모 클래스에서 선언한 반환 타입의 서브타입으로 지정할 수 있는 특성
        // (참고) 자바는 리턴타입 공변성을 지원하지만 C#은 리턴타입 공변성을 지원하지 않는다.
        return new Megazine(independentPublisher);
    }
}
