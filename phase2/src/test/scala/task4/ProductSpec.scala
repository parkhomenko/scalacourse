package task4

import org.scalatest.{FlatSpec, Matchers}

class ProductSpec extends FlatSpec with Matchers {
  val product = new Product

  "A product of elements of the List(2, 5, 10)" should "be 100 without tail recursion" in {
    product.withoutTailRecursion(List(2, 5, 10)) shouldBe 100
  }

  it should "be 100 with tail recursion" in {
    product.withTailRecursion(List(2, 5, 10)) shouldBe 100
  }
}
