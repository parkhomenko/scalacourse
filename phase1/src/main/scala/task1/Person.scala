package task1

import java.time.{LocalDate, Period}

class Person {
  private var name = ""
  var dateOfBirth = LocalDate.now()
}

object Person {
  def create(name: String, dateOfBirth: LocalDate): Person = {
    val person = new Person
    person.name = name
    person.dateOfBirth = dateOfBirth
    person
  }

  def calculateAge(person: Person): Int = {
    val period = Period.between(person.dateOfBirth, LocalDate.now())
    period.getYears
  }
}
