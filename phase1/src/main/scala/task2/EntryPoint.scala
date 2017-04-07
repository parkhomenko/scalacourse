package task2

object EntryPoint extends App {
  val noPrimes = 2 :: 4 :: 8 :: 14 :: Nil
  println(s"The list $noPrimes contains primes: ${Primes.hasPrimes(noPrimes)}")

  val withPrimes = 3 :: 5 :: 7 :: 11 :: 13 :: Nil
  println(s"The list $withPrimes contains primes: ${Primes.hasPrimes(withPrimes)}")
}
