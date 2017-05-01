package task1

import scala.util.parsing.combinator.JavaTokenParsers

class Html extends JavaTokenParsers {
  def textContent: Parser[String] = """[a-z]*""".r

  def tagName: Parser[String] = """[a-z]+""".r

  def doctype: Parser[String] = """<!doctype html>\s*""".r

  def htmlTagOpen: Parser[String] = """<html>\s*""".r

  def htmlTagClose: Parser[String] = """\s*</html>""".r

  def bodyTagOpen: Parser[String] = """<body>\s*""".r

  def bodyTagClose: Parser[String] = """\s*</body>""".r

  def singleTag: Parser[String] = "<" ~ tagName ~ "/>" ^^ { case "<" ~ tagName ~ "/>" => tagName }

  def doubleTag: Parser[(String, Any)] = "<" ~ tagName ~ ">" ~ content ~ "</" ~ tagName ~ ">" ^^ { case "<" ~ openTagName ~ ">" ~ content ~ "</" ~ closeTagName ~ ">" => (openTagName, content) }

  def content: Parser[Any] = rep(doubleTag) ^^ { case tag => List() ++ tag } | textContent ^^ (_.toString)

  def document: Parser[Any] = doctype ~ htmlTagOpen ~ bodyTagOpen ~ content ~ bodyTagClose ~ htmlTagClose ^^ { case doctype ~ htmlTagOpen ~ bodyTagOpen ~ content ~ bodyTagClose ~ htmlTagClose => content }
}

object HtmlParser extends Html {
  def parse(html: String) = parseAll(document, html)
}
