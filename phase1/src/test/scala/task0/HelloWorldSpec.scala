package task0

import org.scalatest.{FlatSpec, Matchers}

class HelloWorldSpec extends FlatSpec with Matchers {
  it should "greet Stan" in {
    val message = HelloWorld.greetings("Stan")
    message should be ("Hello, Stan")
  }

  it should "greet James" in {
    val message = HelloWorld.greetings("James")
    message should be ("Hello, James")
  }

  it should "greet Jonathan" in {
    val message = HelloWorld.greetings("Jonathan")
    message should be ("Hello, Jonathan")
  }
}
