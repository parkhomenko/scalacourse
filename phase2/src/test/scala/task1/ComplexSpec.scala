package task1

import org.scalatest.{FlatSpec, Matchers}

class ComplexSpec extends FlatSpec with Matchers {
  val number1 = Complex(3, 2)
  val number2 = Complex(5, 3)

  "A number (3 + 2i)" should "result in (8 + 5i) when I add (5 + 3i)" in {
    number1 + number2 shouldBe Complex(8, 5)
  }

  it should "result in (-2 - i) when I subtract (5 + 3i)" in {
    number1 - number2 shouldBe Complex(-2, -1)
  }
}
