package task2

import org.scalatest.{FlatSpec, Matchers}

class PrimesSpec extends FlatSpec with Matchers {
  "The List of [2, 6, 10]" should "not have primes" in {
    val list = List(2, 6, 10)
    Primes.hasPrimes(list) should be (false)
  }

  "The List of [3, 5, 11]" should "have primes" in {
    val list = List(3, 5, 11)
    Primes.hasPrimes(list) should be (true)
  }

  "The List of [2, 3, 5, 11, 35]" should "have primes" in {
    val list = List(3, 5, 11)
    Primes.hasPrimes(list) should be (true)
  }
}
