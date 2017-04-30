package task1

import scala.util.parsing.combinator.JavaTokenParsers

class Html extends JavaTokenParsers {
  def textContent: Parser[String] = """[^<>/]*""".r
  def tagName: Parser[String] = """[a-z]+""".r
  def doctype: Parser[String] = "<!doctype html>"
  def htmlTagOpen: Parser[String] = """<html>\s*""".r
  def htmlTagClose: Parser[String] = """\s*</html>""".r
  def bodyTagOpen: Parser[String] = """<body>\s*""".r
  def bodyTagClose: Parser[String] = """\s*</body>""".r
  def singleTag: Parser[Any] = "<"~tagName~"/>"
  def doubleTag: Parser[Any] = "<"~tagName~">"~content~"</"~tagName~">"
  def content: Parser[Any] = singleTag | doubleTag | textContent
}

object HtmlParser extends Html {
  def main(args: Array[String]): Unit = {
    val html = "<test>something</test>"
    val result = parseAll(content, html)
    println(result)
  }
}
