// Example program
#include <iostream>
#include <string>

using namespace std;

class SalariedEmployee {
private:
    string name;
    long base_pay;

public:
    SalariedEmployee(string name, long base_pay);

    long calculate_pay(double tax_rate);

};

SalariedEmployee::SalariedEmployee(string name, long base_pay) {
    this->name = name;
    this->base_pay = base_pay;
}

long SalariedEmployee::calculate_pay(double tax_rate) {
    return base_pay - (base_pay * tax_rate);
}

class HourlyEmployee {
private:
    string name;
    long base_pay;
    int time_card;
public:
    HourlyEmployee(string name, long base_pay, int timeCard);
    long calculate_pay(double tax_rate);
};

HourlyEmployee::HourlyEmployee(string name, long base_pay, int timeCard) {
    this->name = name;
    this->base_pay = base_pay;
    this->time_card = timeCard;
}

long HourlyEmployee::calculate_pay(double tax_rate) {
    return (base_pay * time_card) - (base_pay * time_card) * tax_rate;
}

template <typename  T>
long calculate(T employee, double tax_rate) { // 템플릿을 이용하여
    return employee.calculate_pay(tax_rate);
}

int main() {
    SalariedEmployee salariedEmployee = SalariedEmployee("Salaried", 100);
    HourlyEmployee hourlyEmployee = HourlyEmployee("Hourly", 1, 40);

    std::cout << calculate(salariedEmployee, 0.1) << std::endl;
    std::cout << calculate(hourlyEmployee, 0.1) << std::endl;
}
