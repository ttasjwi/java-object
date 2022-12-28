package com.ttasjwi.employee;

import com.ttasjwi.money.Money;

public class Main {

    public static void main(String[] args) {
        var salariedEmployee = new SalariedEmployee("땃쥐", Money.wons(100));
        var hourlyEmployee = new HourlyEmployee("아르바이트A", Money.wons(1), 40);
        // calculate(salariedEmployee, 0.2); // 컴파일 에러!!! -> 자바에서는 덕타이핑이 지원되지 않는다!
        // calculate(houlyEmployee, 0.2); // 컴파일 에러!!!
    }

    private static Money calculate(Employee employee, double taxRate) {
        return employee.calculateFee(taxRate);
    }
}
