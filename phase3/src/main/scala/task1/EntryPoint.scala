package task1

import scala.io.StdIn

object EntryPoint extends App {
  val input = StdIn.readLine.split(" ")
  val tuple = (input(0), input(1))

  val result = tuple match {
    case (fileName: String, "hashmap") => FileProcessor(fileName, "hashmap").process
    case (fileName: String, "treemap") => FileProcessor(fileName, "treemap").process
    case _ => throw new IllegalArgumentException
  }

  result.foreach(println)
}
