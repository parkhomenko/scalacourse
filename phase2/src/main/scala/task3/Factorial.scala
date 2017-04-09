package task3

class Factorial {
  def withoutTailRecursion(value: Int): Int = {
    if (value == 1) 1
    else value * withoutTailRecursion(value - 1)
  }

  def withTailRecursion(value: Int): Int = {
    def countFactorial(cnt: Int, fact: Int): Int = {
      if (cnt == 1) fact
      else countFactorial(cnt - 1, cnt * fact)
    }
    countFactorial(value, 1)
  }
}
