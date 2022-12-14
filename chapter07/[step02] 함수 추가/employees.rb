#encoding: UTF-8
$employees = ["직원A", "직원B", "직원C"] # 직원
$basePays = [400, 300, 250] # 기본 급여

def main(name)
  taxRate = getTaxRate() # 세율 입력
  pay = calculatePayFor(name, taxRate) # 최종 급여 계산
  puts(describeResult(name, pay)) # 결과를 형식화하여 출력
end

# 세율을 입력하여 반환
def getTaxRate()
  print("세율을 입력하세요: ")
  return gets().chomp().to_f()
end

# 급여 계산
def calculatePayFor(name, taxRate)
  index = $employees.index(name) # 직원의 인덱스 획득
  basePay = $basePays[index] # 직원의 기본 급여 획득
  return basePay - (basePay * taxRate) # 직원의 급여 계산 후 반환
end

# 직원의 급여 계산 결과를 문자열로 변환
def describeResult(name, pay)
  return "이름 : #{name}, 급여 : #{pay}"
end

# 모든 직원들의 기본급 반환
def sumOfBasePays()
  result = 0
  for basePay in $basePays
    result += basePay
  end
  puts(result)
end

main("직원A")
