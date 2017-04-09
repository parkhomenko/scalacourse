package task5

import scala.collection.mutable

object Fibonacci {
  private val numbers = mutable.Map.empty[Int, Int]

  def calculate(number: Int, isTailRecursive: Boolean) = {
    def calculateSpecificFunction = {
      if (isTailRecursive) withTailRecursion(number)
      else withoutTailRecursion(number)
    }

    if (numbers.contains(number)) numbers(number)
    else {
      val result = calculateSpecificFunction
      numbers += (number -> result)
      result
    }
  }

  private def withoutTailRecursion(number: Int): Int = {
    if (number == 1 || number == 2) 1
    else withoutTailRecursion(number - 1) + withoutTailRecursion(number - 2)
  }

  private def withTailRecursion(number: Int): Int = {
    def count(cnt: Int, prev: (Int, Int)): Int = {
      val current = prev._1 + prev._2
      if (number == cnt) current
      else count(cnt + 1, (prev._2, current))
    }

    if (number == 1 || number == 2) 1
    else count(3, (1, 1))
  }
}
