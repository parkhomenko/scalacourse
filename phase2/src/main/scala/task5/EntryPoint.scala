package task5

import scala.io.StdIn;

object EntryPoint extends App {
  var number = StdIn.readInt()
  do {
    println(Fibonacci.calculate(number, true))
    number = StdIn.readInt()
  } while (number != 0)
}
