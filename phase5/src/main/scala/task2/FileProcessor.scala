package task2

import scala.collection.{immutable, mutable}
import scala.io.Source

case class FileProcessor(fileName: String, storage: String) {

  private val map = storage match {
    case "hashmap" => new mutable.HashMap[String, Int]
    case "treemap" => new mutable.TreeMap[String, Int]
    case _ => throw new IllegalArgumentException
  }

  private def getLines: List[String] = {
    val source = Source.fromResource(fileName)
    try source.getLines().toList finally source.close()
  }

  private def convertToImmutableMap: immutable.Map[String, Int] = {
    val immutableMap = storage match {
      case "hashmap" => new immutable.HashMap[String, Int]
      case "treemap" => new immutable.TreeMap[String, Int]
      case _ => throw new IllegalArgumentException
    }
    immutableMap ++ map
  }

  def process: Map[String, Int] = {
    def processLine(line: String) =
      line.split(" ").foreach(processWord)

    def processWord(word: String) =
      map += word -> (map.getOrElse(word, 0) + 1)

    getLines.foreach(processLine)
    convertToImmutableMap
  }
}
