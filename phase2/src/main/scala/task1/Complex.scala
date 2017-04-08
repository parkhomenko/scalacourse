package task1

class Complex private(a: Int, b: Int) extends Ordered[Complex] {
  private val real = a
  private val imag = b

  /**
    * Addition operation of 2 complex numbers
    * @param that a complex number '''addend'''
    * @return result is the '''sum''' of complex numbers
    */
  def +(that: Complex): Complex = Complex(this.real + that.real, this.imag + that.imag)

  /**
    * Addition operation of a complex number and a real number
    * @param real a real number '''addend'''
    * @return result is the '''sum''' of a complex number and a real number
    */
  def +(real: Int): Complex = Complex(this.real + real, this.imag)

  /**
    * Subtraction operation of 2 complex numbers
    * @param that a complex number '''subtrahend'''
    * @return result is the '''subtraction''' of complex numbers
    */
  def -(that: Complex): Complex = Complex(this.real - that.real, this.imag - that.imag)

  /**
    * Subtraction operation of a complex number and a real number
    * @param real a real number '''subtrahend'''
    * @return result is the '''subtraction''' of a complex number and a real number
    */
  def -(real: Int): Complex = Complex(this.real - real, this.imag)

  /**
    * Multiplication operation of 2 complex numbers
    * @param that a complex number '''multiplier'''
    * @return result is the '''multiplication''' of complex numbers
    */
  def *(that: Complex): Complex =
    Complex(
      this.real * that.real - this.imag * that.imag,
      this.imag * that.real + this.real * that.imag
    )

  /**
    * Multiplication operation of a complex number and a real number
    * @param real a real number '''multiplier'''
    * @return result is the '''multiplication''' of a complex number and a real number
    */
  def *(real: Int): Complex = Complex(this.real * real, this.imag * real)

  /**
    * Division operation of 2 complex numbers
    * @param that a complex number '''divisor'''
    * @return result is a '''division''' of complex numbers
    */
  def /(that: Complex): Complex = {
    require(that.real > 0 || that.imag > 0)
    val denom = sqr(that.real) + sqr(that.imag)
    Complex(
      (this.real * that.real + this.imag * that.imag) / denom,
      (this.imag * that.real - this.real * that.imag) / denom
    )
  }

  /**
    * Division operation of a complex number and a real number
    * @param real a real number '''divisor'''
    * @return result is a '''division''' of a complex number and a real number
    */
  def /(real: Int): Complex = {
    require(real > 0)
    val denom = sqr(real)
    Complex(
      (this.real * real) / denom,
      (this.imag * real) / denom
    )
  }

  /**
    * Conjugation of a complex number
    * @return a '''conjugated''' complex number
    */
  def unary_-(): Complex = Complex(this.real, -this.imag)

  /**
    * Computes '''magnitude''' of the number
    * @return the result is a '''magnitude''' of this number
    */
  def abs: Double = math.sqrt(sqr(this.real) + sqr(this.imag))

  /**
    * Computes '''phase angle of the number'''
    * @return the result is a '''phase angle''' of this number
    */
  def phaseAngle: Double = math.atan2(this.imag, this.real)

  private def sqr(v: Int) = v * v

  override def compare(that: Complex): Int = {
    val byAbs = (this.abs - that.abs).toInt
    if (byAbs == 0) (this.phaseAngle - that.phaseAngle).toInt
    else byAbs
  }

  override def hashCode() = (a, b).##

  override def equals(other: Any) = other match {
    case that: Complex => this.real == that.real && this.imag == that.imag
    case _ => false
  }

  override def toString: String = {
    if (a == 0 && b == 0) 0.toString
    else if (b == 0) a.toString
    else if (a == 0) s"${b}i"
    else if (b < 0) s"$a - ${b.abs}i"
    else s"$a + ${b}i"
  }
}

object Complex {
  def apply(a: Int, b: Int): Complex = new Complex(a, b)
}
