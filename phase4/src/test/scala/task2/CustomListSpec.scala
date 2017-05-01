package task2

import org.scalatest.{FlatSpec, Matchers}

class CustomListSpec extends FlatSpec with Matchers {

  val list = 1 :: 2 :: 3 :: 4 :: 5 :: CustomNil

  "List(1, 2, 3, 4, 5)" should "become List(0, 1, 2, 3, 4, 5) when I add 0" in {
    val newList = list.::(0)
    newList shouldBe 0 :: 1 :: 2 :: 3 :: 4 :: 5 :: CustomNil
  }

  it should "become List(4, 5) when I drop 3 elements from it" in {
    val newList = list drop 3
    newList shouldBe 4 :: 5 :: CustomNil
  }

  it should "become List(2, 4, 6, 8, 10) when I map it to a (x * 2) function" in {
    val newList = list.map(elem => elem * 2)
    newList shouldBe 2 :: 4 :: 6 :: 8 :: 10 :: CustomNil
  }

  it should "be of length 5" in {
    list.length shouldBe 5
  }

  it should "be empty if I drop all its 5 elements" in {
    (list drop 5).isEmpty shouldBe true
  }
}
