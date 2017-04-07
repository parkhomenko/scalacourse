package task2

object Primes {

  def hasPrimes(list: List[Int]): Boolean = list.exists(isPrime)

  def isPrime(number: Int):Boolean = {
    if (number % 2 == 0)
      false
    else
      !(3 to number / 2 by 3).exists(number % _ == 0)
  }
}
