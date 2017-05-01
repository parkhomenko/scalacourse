package task1

import org.scalatest.{FlatSpec, Matchers}

class HtmlParserSpec extends FlatSpec with Matchers {
  val html = "<!doctype html>" +
    "<html>" +
      "<body>" +
        "<test>" +
          "<a>" +
            "<strong>something</strong>" +
            "<p>anothertext</p>" +
          "</a>" +
        "</test>" +
      "</body>" +
    "</html>"

  it should "parse html" in {
    val result = HtmlParser.parse(html)
    val strong = ("strong", Nil)
    val p = ("p", Nil)
    val a = ("a", strong :: p :: Nil)
    val test = ("test", a :: Nil)
    result shouldBe List(test)
  }
}
