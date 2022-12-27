package com.ttasjwi.function.variance

class Orderer {
  var book: Book = null;

  def order(store: IndependentPublisher => Book): Unit = {
    book = store(new IndependentPublisher()) // 함수에 IndepedentPublisher를 전달
  }

}

object Main extends App {
  new Orderer().order((publisher: IndependentPublisher) => new Book(publisher))

  //def order(store: IndependentPublisher => Book)
  // 파라미터 타입 반공변성 (IndepententPublisher <- Publisher)
  // 리턴타입 공변성 (Book -> Megazine)
  // 파라미터 타입이 반공변적이고, 리턴타입이 공변적이므로 함수의 타입은 명시된 타입의 서브타입이다.
  new Orderer().order((publisher: Publisher) => new Megazine(publisher))
}
