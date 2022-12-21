class Lecture

  def initialize(name, scores)
    @name = name
    @scores = scores
  end

  def stats(this) # this에는 메시지를 수신한 객체를 가리키는 self 참조가 보관된다.
    "Name: #{@name}, Evaluation Method: #{this.getEvaluationMethod()}"
  end

  def getEvaluationMethod()
    "Pass or Fail"
  end
end

class GradeLecture
  def initialize(name, canceled, scores)
    @parent = Lecture.new(name, scores)
    @canceled = canceled
  end

  def stats(this)
    @parent.stats(this) # '@parent'의 메서드를 호출한다.
  end

  def getEvaluationMethod()
    "Grade"
  end
end

lecture = Lecture.new("OOP", [1,2,3])
puts lecture.stats(lecture)

grade_lecture = GradeLecture.new("OOP", false, [1,2,3])
puts grade_lecture.stats(grade_lecture)
