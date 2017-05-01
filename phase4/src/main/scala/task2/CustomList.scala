package task2

abstract class CustomList[+T] {
  def isEmpty: Boolean
  def head: T
  def tail: CustomList[T]

  def length: Int = if (isEmpty) 0 else 1 + tail.length

  def ::[U >: T](item: U): CustomList[U] = new ::(item, this)

  def drop(n: Int): CustomList[T] = {
    if (isEmpty) CustomNil
    else if (n <= 0) this
    else tail.drop(n - 1)
  }

  def map[U](func: T => U): CustomList[U] = {
    if (isEmpty) CustomNil
    else func(head) :: tail.map(func)
  }
}

case object CustomNil extends CustomList[Nothing] {
  override def isEmpty = true
  override def head: Nothing = throw new NoSuchElementException("head of empty list")
  override def tail: CustomList[Nothing] = throw new NoSuchElementException("tail of empty list")
}

final case class ::[T](head: T, tail: CustomList[T]) extends CustomList[T] {
  override def isEmpty = false
  override def length: Int = if (isEmpty) 0 else 1 + tail.length
}
