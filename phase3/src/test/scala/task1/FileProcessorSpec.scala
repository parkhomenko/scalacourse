package task1

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.immutable.{HashMap, TreeMap}

class FileProcessorSpec extends FlatSpec with Matchers {
  "File test.txt" should "be a HashMap of (cruel,1)(world,3)(wonderful,1)(hello,3)" in {
    val processor = FileProcessor("test.txt", "hashmap")
    val result = processor.process
    result shouldBe Map("cruel" -> 1, "world" -> 3, "wonderful" -> 1, "hello" -> 3)
    result shouldBe an[HashMap[String, Int]]
  }

  it should "be a TreeMap of (cruel,1)(world,3)(wonderful,1)(hello,3)" in {
    val processor = FileProcessor("test.txt", "treemap")
    val result = processor.process
    result shouldBe Map("cruel" -> 1, "world" -> 3, "wonderful" -> 1, "hello" -> 3)
    result shouldBe an[TreeMap[String, Int]]
  }
}
