package com.ttasjwi.billing;

public class Main {

    public static void main(String[] args) {
        // BasicRatePolicy에 더 강력한 사전 조건 추가 -> 계약 위반 -> 리스코프 치환 원칙 위반
        // Phone regularPhone1 = new Phone(new RegularPolicy(Money.wons(10), Duration.ofSeconds(10)));
        // regularPhone1.publishBill();


    }
}
