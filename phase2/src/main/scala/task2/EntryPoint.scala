package task2

object EntryPoint extends App {
  val textReader = new TextReader
  val lines = textReader.readFile("text.txt")
  println(lines)
}
