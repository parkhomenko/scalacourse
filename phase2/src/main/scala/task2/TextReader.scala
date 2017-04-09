package task2

import scala.io.Source

class TextReader {
  def readFile(file: String): List[String] = {
    val text = Source.fromResource(file).getLines().toList
    for (line <- text; if line.length > 10)
      yield line
  }
}
