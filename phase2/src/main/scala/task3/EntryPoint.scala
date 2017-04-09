package task3

object EntryPoint extends App {
  val factorial = new Factorial
  println(factorial.withoutTailRecursion(5))
  println(factorial.withTailRecursion(5))
}
