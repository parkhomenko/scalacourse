package task2

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

class WordCount(fileName1: String, fileName2: String, storage: String) {

  def process = {
    if (storage == "hashmap" || storage == "treemap") {
      val fut1 = Future { FileProcessor(fileName1, "hashmap").process }
      val fut2 = Future { FileProcessor(fileName2, "hashmap").process }
      for {
        map1 <- fut1
        map2 <- fut2
      } yield map1 ++ map2.map {
        case (key, value) => key -> (value + map1.getOrElse(key, 0))
      }
    } else {
      throw new IllegalArgumentException
    }
  }
}
