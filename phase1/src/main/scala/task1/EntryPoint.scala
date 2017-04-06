package task1

import java.time.{LocalDate, Month}

object EntryPoint extends App {
  val name = "John Wayne"
  val person = Person.create(name, LocalDate.of(1986, Month.APRIL, 25))
  val age = Person.calculateAge(person)
  println(s"$name's age is $age years old")
}
