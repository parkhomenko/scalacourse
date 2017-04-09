package task5

import org.scalatest.{FlatSpec, Matchers}

class FibonacciSpec extends FlatSpec with Matchers {
  "The 8th element in the fibonacci sequence" should "be 21 not using tail recursion" in {
    Fibonacci.calculate(8, false) should be (21)
  }

  "The 9th element in the fibonacci sequence" should "be 34 using tail recursion" in {
    Fibonacci.calculate(9, true) should be (34)
  }

  "The 8th and 9th elements now" should "be got from cache and result in 21 and 34" in {
    Fibonacci.calculate(8, true) should be (21)
    Fibonacci.calculate(9, true) should be (34)
  }
}
