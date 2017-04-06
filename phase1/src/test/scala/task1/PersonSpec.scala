package task1

import java.time.{LocalDate, Month, Period}

import org.scalatest.{FlatSpec, Matchers}

class PersonSpec extends FlatSpec with Matchers {
  "A person who was born at 28 of June in 1984" should "be 32 years old now" in {
    val person = Person.create("Stan", LocalDate.of(1984, Month.JUNE, 28))
    val age = Person.calculateAge(person)
    val diff = Period.between(LocalDate.now(), LocalDate.of(2017, Month.APRIL, 6)).getYears
    age should be (32 + diff)
  }
}
