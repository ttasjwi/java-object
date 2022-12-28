#encoding: UTF-8

class Employee
  def calculatePay(taxRate)
    raise NotImplementedError
  end
end

class SalariedEmployee

  def initialize(name, basePay)
    @name = name
    @basePay = basePay
  end

  def calculatePay(taxRate)
    @basePay - (@basePay * taxRate)
  end
end

class HourlyEmployee < Employee

  def initialize(name, basePay, timeCard)
    @name = name
    @basePay = basePay
    @timeCard = timeCard
  end

  def calculatePay(taxRate)
    (@basePay * @timeCard) - (@basePay * @timeCard) * taxRate
  end
end

def calculate(employee, taxRate)
  employee.calculatePay(taxRate)
end

salariedEmployee = SalariedEmployee.new("땃쥐", 100)
hourlyEmployee = HourlyEmployee.new("아르바이트A", 1, 40)

puts calculate(salariedEmployee, 0.1) # 성공!
puts calculate(hourlyEmployee, 0.1) # 성공!
