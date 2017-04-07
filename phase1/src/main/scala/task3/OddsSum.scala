package task3

object OddsSum {
  def sumElements(list: List[Int]): Int = {
    list.filterNot(_ % 2 == 0)
      .foldLeft(0) {
        sum(_)(_)
      }
  }

  private def sum(a: Int)(b: Int) = a + b
}
