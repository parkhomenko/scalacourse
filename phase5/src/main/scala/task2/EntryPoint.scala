package task2

import scala.concurrent.Future
import scala.io.StdIn
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object EntryPoint extends App {
  val input = StdIn.readLine.split(" ")
  val fileName1 = input(0)
  val fileName2 = input(1)
  val storage = input(2)

  val wordCount = new WordCount(fileName1, fileName2, storage)
  val result = wordCount.process

  result onComplete {
    case Success(res) => println(res)
    case Failure(ex) => println(ex)
  }

  waitABit

  private def waitABit = {
    val delay = Future { Thread.sleep(1000) }
    while (!delay.isCompleted) {}
  }
}
