package task3

import org.scalatest.{FlatSpec, Matchers}

class FactorialSpec extends FlatSpec with Matchers {
  val factorial = new Factorial

  "A factorial of 5" should "be 120 in withoutTailRecursion function" in {
    factorial.withoutTailRecursion(5) should be (120)
  }

  it should "be 120 in withTailRecursion function" in {
    factorial.withTailRecursion(5) should be (120)
  }
}
