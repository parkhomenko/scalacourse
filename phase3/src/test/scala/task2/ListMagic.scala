package task2

import org.scalatest.{FlatSpec, Matchers}

class ListMagic extends FlatSpec with Matchers {
  val list = 1 :: 2 :: 3 :: Nil

  it should "create a List(1, 2, 3, 4, 5) out of List.range(1, 6)" in {
    val list = List.range(1, 6)
    list shouldBe List(1, 2, 3, 4, 5)
  }

  it should "create a List(1, 3, 5) out of List.range(1, 6, 2)" in {
    val list = List.range(1, 6, 2)
    list shouldBe List(1, 3, 5)
  }

  it should "fill the List with 'foo' 3 times" in {
    val list = List.fill(3)("foo")
    list shouldBe List("foo", "foo", "foo")
  }

  it should "fill the List according to the function" in {
    val list = List.tabulate(5)(n => n * n)
    list shouldBe List(0, 1, 4, 9, 16)
  }

  it should "prepend 0" in {
    val newList = 0 :: list
    newList shouldBe List(0, 1, 2, 3)
  }

  it should "merge List(4, 5, 6)" in {
    val newList = list ::: List(4, 5, 6)
    newList shouldBe List(1, 2, 3, 4, 5, 6)
  }

  it should "return sum of all elements using foreach" in {
    var sum = 0
    list.foreach(sum += _)
    sum should be (6)
  }

  it should "return odd elements using for loop" in {
    val newList = for (item <- list if item % 2 != 0) yield item
    newList shouldBe List(1, 3)
  }

  it should "return odd elements using filter" in {
    val newList = list.filter(_ % 2 != 0)
    newList shouldBe List(1, 3)
  }

  it should "change every element according to a function" in {
    val newList = list.map(_ * 2)
    newList shouldBe List(2, 4, 6)
  }

  it should "sort elements in descending order" in {
    val newList = list.sortWith(_ > _)
    newList shouldBe List(3, 2, 1)
  }

  it should "convert a List to a String" in {
    val result = list.mkString
    result should be ("123")
  }

  it should "create a single list" in {
    val listOfLists = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
    val newList = listOfLists.flatten
    newList shouldBe List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  }

  it should "return sum of elements using foldLeft function" in {
    val sum = (10 /: list)(_ - _)
    sum should be (4)
  }

  it should "return sum of elements using foldRight function" in {
    val sum = (list :\ 10)(_ - _)
    sum should be (-8)
  }
}
