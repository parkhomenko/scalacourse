package task0

object HelloWorld {
  def main(args: Array[String]): Unit = println(greetings("Stan"))
  def greetings(name: String): String = "Hello, " + name
}
