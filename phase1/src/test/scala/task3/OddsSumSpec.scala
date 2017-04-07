package task3

import org.scalatest.{FlatSpec, Matchers}

class OddsSumSpec extends FlatSpec with Matchers {
  "The list of [1, 2, 3, 4, 5]" should "return 9" in {
    val list = 1 :: 2 :: 3 :: 4 :: 5 :: Nil
    val sum = OddsSum.sumElements(list)
    sum should be (9)
  }

  "The list of [1, 2, 4, 5, 8]" should "return 6" in {
    val list = 1 :: 2 :: 4 :: 5 :: 8 :: Nil
    val sum = OddsSum.sumElements(list)
    sum should be (6)
  }
}
