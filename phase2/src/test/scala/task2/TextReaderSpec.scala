package task2

import org.scalatest.{FlatSpec, Matchers}

class TextReaderSpec extends FlatSpec with Matchers {
  "When I read lines from text.txt it" should
    "return List(hello world, hello cruel world, I think therefore I am)" in {
    val textReader = new TextReader
    textReader.readFile("text.txt") shouldBe
      List("hello world", "hello cruel world", "I think therefore I am")
  }
}
