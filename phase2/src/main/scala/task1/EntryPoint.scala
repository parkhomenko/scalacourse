package task1

object EntryPoint extends App {
  val complex = Complex(5, 3)
  println(complex)

  val n1 = Complex(2, 8)
  val n2 = Complex(3, 9)
  println(n1 + n2)

  println(-n1)
}
