#encoding: UTF-8

Employee = Struct.new(:name, :basePay, :hourly, :timeCard) do

  # 직원의 세후 급여 계산
  def calculatePay(taxRate)
    if (hourly) then # 아르바이트 직원 여부 확인
      return calculateHourlyPay(taxRate) # 아르바이트 직원 급여 계산
    end
    return calculateSalariedPay(taxRate) # 정직원 급여 계산
  end

  def monthlyBasePay()
    if (hourly) then return 0 end
    return basePay
  end

private
  # 정직원 급여 계산
  def calculateSalariedPay(taxRate)
    return (basePay * timeCard) - (basePay * taxRate)
  end

  # 아르바이트 직원 급여 계산
  def calculateHourlyPay(taxRate)
    return (basePay * timeCard) - (basePay * timeCard) * taxRate
  end

end

$employees = [
  Employee.new("직원A", 400, false, 0),
  Employee.new("직원B", 300, false, 0),
  Employee.new("직원C", 250, false, 0),
  Employee.new("아르바이트D", 1, true, 120),
  Employee.new("아르바이트E", 1, true, 120),
  Employee.new("아르바이트F", 1.5, true, 120),
]

def main(operation, args={})
  case(operation)
  when :pay then calculatePay(args[:name])
  when :basePays then sumOfBasePays()
  end
end

def calculatePay(name)
  taxRate = getTaxRate()
  for each in $employees
    if (each.name == name) then employee = each; break end
  end
  pay = employee.calculatePay(taxRate)
  puts(describeResult(name, pay))
end

# 세율을 입력
def getTaxRate()
  print("세율을 입력하세요: ")
  return gets().chomp().to_f()
end

# 직원의 급여 계산 결과를 문자열로 포맷팅
def describeResult(name, pay)
  return "이름 : #{name}, 급여 : #{pay}"
end

# 모든 직원들의 기본급 출력
def sumOfBasePays()
  result = 0
  for each in $employees
    result += each.monthlyBasePay()
  end
  puts(result)
end

main(:basePays)
main(:pay, name:"아르바이트F")
