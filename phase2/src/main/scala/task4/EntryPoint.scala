package task4

object EntryPoint extends App {
  val product = new Product

  println(product.withoutTailRecursion(1 :: 5 :: 8 :: Nil))
  println(product.withTailRecursion(1 :: 5 :: 8 :: Nil))
}
