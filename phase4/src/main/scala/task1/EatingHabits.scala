package task1

object EatingHabits {

  class Food

  abstract class Animal {
    type SuitableFood <: Food
    def eat(food: SuitableFood)
  }

  class Grass extends Food
  class HumanFood extends Food
  class Fish extends HumanFood
  class Steak extends HumanFood

  class Cow extends Animal {
    type SuitableFood = Grass

    override def eat(food: Grass): Unit = {
      println("I ate lots of grass today")
    }
  }

  class Human extends Animal {
    type SuitableFood = HumanFood

    override def eat(food: HumanFood): Unit = {
      println("I ate only human food")
    }
  }

  class Dog extends Animal {
    type SuitableFood = Steak

    override def eat(food: Steak): Unit = {
      println("I'm a dog but I like steaks")
    }
  }
}
