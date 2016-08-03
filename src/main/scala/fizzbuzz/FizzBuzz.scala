package fizzbuzz

import scala.annotation.tailrec

object FizzBuzz extends App {
  def apply(start: Int, end: Int): (IndexedSeq[Any], Map[_ >: String, Int]) = {
    val contains3 = (n: Int) => n.toString.contains("3")
    val multOf = (n: Int, divisor: Int) => n % divisor == 0
    val multOf3 = (n: Int) => multOf(n, 3)
    val multOf5 = (n: Int) => multOf(n, 5)
    val multOf15 = (n: Int) => multOf(n, 15)

    FizzBuzz(start, end, List((contains3, "lucky"), (multOf15, "fizzbuzz"), (multOf3, "fizz"), (multOf5, "buzz")))
  }

  def apply(start: Int, end: Int, orderedOverrides: List[(Int => Boolean, String)]): (IndexedSeq[Any], Map[_ >: String, Int]) = {

    @tailrec
    def loop(n: Int, overrides: List[(Int => Boolean, String)]): Any = overrides match {
      case Nil                => n
      case (pred, label) :: t => if (pred(n)) label else loop(n, t)
    }

    val fb = (start to end).map(loop(_, orderedOverrides))
    (fb, fb.map {
      case _: Int => "integer"
      case label  => label
    }.groupBy(identity).mapValues(_.size))
  }
}