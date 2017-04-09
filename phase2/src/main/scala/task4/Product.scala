package task4

class Product {
  def withoutTailRecursion(list: List[Int]): Int = {
    if (list == Nil) 1
    else list.head * withoutTailRecursion(list.tail)
  }

  def withTailRecursion(list: List[Int]): Int = {
    def product(list: List[Int], prod: Int): Int = {
      if (list == Nil) prod
      else product(list.tail, prod * list.head)
    }
    product(list, 1)
  }
}
