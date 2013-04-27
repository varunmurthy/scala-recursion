package recfun
import common._

/*	
Picture of Pascal's Triangle for reference 
        
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1
*/

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: => Int, r: => Int): Int = {
    // If value is at the edge of triangle then return 1
    if ((c == 0 || c == r)) 1

    // Else add the values from the previous row but to the left and right of the element
    else (pascal(c - 1, r - 1) + pascal(c, r - 1))
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    // Function that computes the new total based on the character that is present at the head of the list	  
    def newTotal(total: Int, c: Char): Int = {
      // If open paran add to total
      if (c == '(') total + 1
      // else if closed paran subtract from total
      else if (c == ')') total - 1
      // else return total
      else total
    }

    // Loop through the characters in the string and keep a count of parans 
    def loop(total: Int, temp: List[Char]): Int = {
      if (temp.isEmpty) total
      else if (total < 0) -1
      else loop(newTotal(total, temp.head), temp.tail)
    }
    loop(0, chars) == 0
  }

  /**
   * Exercise 3
   */

  def countChange(money: Int, coins: List[Int]): Int = {
    val sortedCoins = coins.sorted(Ordering[Int].reverse).distinct
    def numways(branch: String, rem: Int, remCoins: List[Int]): Int = {
      //println(branch, rem, remCoins)
      if (rem == 0) 1
      else if (rem < 0) 0
      else if ((remCoins.isEmpty) && rem > 0) 0
      else numways("Left", rem - remCoins.head, remCoins) + numways("Right", rem, remCoins.tail)
    }
    numways("Original", money, coins)
  }
  countChange(300,List(500,5,50,100,20,200,10))
}
