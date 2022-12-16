#encoding: UTF-8

module Employees
  $employees = ["직원A", "직원B", "직원C", "아르바이트D", "아르바이트E", "아르바이트F"] # 직원명
  $basePays = [400, 300, 250, 1, 1, 1.5] # 기본 급여
  $hourlys = [false, false, false, true, true, true] # 아르바이트 직원인지 여부
  $timeCards = [0, 0, 0, 120, 120, 120] # 아르바이트 직원일 경우 시급

  # 직원의 세후 급여 계산
  def Employees.calculatePay(name, taxRate)
    if (Employees.hourly?(name)) then # 아르바이트 직원 여부 확인
      pay = Employees.calculateHourlyPayFor(name, taxRate) # 아르바이트 직원 급여 계산
    else
      pay = Employees.calculatePayFor(name, taxRate) # 정직원 급여 계산
    end
    return pay
  end

  # 아르바이트 직원 여부 확인
  def Employees.hourly?(name)
    return $hourlys[$employees.index(name)]
  end

  # 정직원 급여 계산
  def Employees.calculatePayFor(name, taxRate)
    index = $employees.index(name) # 직원의 인덱스 획득
    basePay = $basePays[index] # 직원의 기본 급여 획득
    return basePay - (basePay * taxRate) # 직원의 급여 계산 후 반환
  end

  # 아르바이트 직원 급여 계산
  def Employees.calculateHourlyPayFor(name, taxRate)
    index = $employees.index(name)
    basePay = $basePays[index] * $timeCards[index]
    return basePay - (basePay * taxRate);
  end

  def Employees.sumOfBasePays()
    result = 0
    for name in $employees
      if(not Employees.hourly?(name)) then
        result += $basePays[$employees.index(name)]
      end
    end
    return result
  end

end

def main(operation, args={})
  case(operation)
  when :pay then calculatePay(args[:name])
  when :basePays then sumOfBasePays()
  end
end

def calculatePay(name)
  taxRate = getTaxRate()
  pay = Employees.calculatePay(name, taxRate)
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
  puts(Employees.sumOfBasePays())
end

main(:basePays)
main(:pay, name:"아르바이트F")
