package fizzbuzz

import org.scalatest.FunSuite

class FizzBuzzSuite extends FunSuite {
  test("single-elem seq") {
		FizzBuzz(2, 2) match {
  		case (fb, report) => 
				assert(fb === Vector(2))
				assert(report === Map("integer" -> 1))
			}
  }
  test("normal seq") {
		FizzBuzz(1, 18) match {
  	  case (fb, report) => 
				assert(fb === Vector(1, 2, "lucky", 4, "buzz", "fizz", 7, 8, "fizz", "buzz", 11, "fizz", "lucky", 14, "fizzbuzz", 16, 17, "fizz"))
				assert(report === Map("integer" -> 9, "lucky" -> 2, "fizz" -> 4, "buzz" -> 2, "fizzbuzz" -> 1))
		}
  }
	test("negative start") {
		FizzBuzz(-4, 18) match {
  		case (fb, report) => 
  			assert(fb === Vector(-4, "lucky", -2, -1, "fizzbuzz", 1, 2, "lucky", 4, "buzz", "fizz", 7, 8, "fizz", "buzz", 11, "fizz", "lucky", 14, "fizzbuzz", 16, 17, "fizz"))
				assert(report === Map("integer" -> 12, "lucky" -> 3, "fizz" -> 4, "buzz" -> 2, "fizzbuzz" -> 2))
		}
	}
	test("10s a 3") {
		FizzBuzz(29, 33) match {
  		case (fb, report) => 
				assert(fb === Vector(29, "lucky", "lucky", "lucky", "lucky"))
				assert(report === Map("integer" -> 1, "lucky" -> 4))
		}
	}
}