
/**
 * 생성자 함수
 */
function Lecture(name, scores) {
    this.name = name;
    this.scores = scores;
}

/**
 * 프로토타입을 통해 메서드 정의
 */
Lecture.prototype.stats = function () {
    // this 키워드에 주의 : this는 Lecture를 가리키는 것이 아니라, 메시지를 수신한 객체의 self 참조이다.
    return `Name: ${this.name} , Evaluation Method: ${this.getEvaluationMethod()}`;
}

Lecture.prototype.getEvaluationMethod = function () {
    return "Pass or fail";
}

function GradeLecture(name, canceled, scores) {
    Lecture.call(this, name, scores); // 생성자를 통해 self 참조를 부모에게 전달한다.
    this.canceled = canceled;
}

/**
 * GradeLecture의 프로토타입을 Lecture로 재할당
 */
GradeLecture.prototype = new Lecture();

GradeLecture.prototype.constructor = GradeLecture;

GradeLecture.prototype.getEvaluationMethod = function () {
    return "Grade";
}

const lecture = new Lecture("OOP", [1, 2, 3]);
console.log(lecture.stats())


const grade_lecture = new GradeLecture("OOP", false, [1, 2, 3]);
console.log(grade_lecture.name);
console.log(grade_lecture.stats());

console.log(lecture.constructor);
console.log(grade_lecture.constructor);
