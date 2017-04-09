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

  it should "result in (9 + 19i) when I multiply by (5 + 3i)" in {
    number1 * number2 shouldBe Complex(9, 19)
  }

  it should "result in (3 - 2i) when I conjugate it" in {
    -number1 shouldBe Complex(3, -2)
  }

  it should "result in 3.606 when I want to find its magnitude" in {
    number1.abs shouldBe 3.606 +- 0.001
  }

  it should "result in 0.588 when I want to find its phase angle" in {
    number1.phaseAngle shouldBe 0.588 +- 0.001
  }

  "A number (50 + 20i)" should "result in (3 - 3i) when I divide by (5 + 10i)" in {
    Complex(50, 20) / Complex(5, 10) shouldBe Complex(3, -3)
  }
}
