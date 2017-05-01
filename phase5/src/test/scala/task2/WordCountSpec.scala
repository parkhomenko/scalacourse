package task2

import org.scalatest.AsyncFunSpec

class WordCountSpec extends AsyncFunSpec {

  val wordCount = new WordCount("test1.txt", "test2.txt", "hashmap")

  describe("counting words in the texts") {
    it("will eventually count all the words in the provided texts") {
      val futureMap = wordCount.process
      futureMap map { result =>
        assert(result == Map("cruel" -> 1, "world" -> 3, "wonderful" -> 1, "hello" -> 3))
      }
    }
  }
}
