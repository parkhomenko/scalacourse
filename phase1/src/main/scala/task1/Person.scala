package task1

import java.time.{LocalDate, Period}

class Person(private var name: String, var dateOfBirth: LocalDate)

object Person {
  def create(name: String, dateOfBirth: LocalDate): Person =
    new Person(name, dateOfBirth)

  def calculateAge(person: Person): Int = {
    val period = Period.between(person.dateOfBirth, LocalDate.now())
    period.getYears
  }
}
