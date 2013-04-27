package recfun

import sun.misc.Sort

object recfun {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(99); 
  println("Welcome to the Scala worksheet");$skip(528); 

  def countChange(money: Int, coins: List[Int]): Int = {
    val sortedCoins = coins.sorted(Ordering[Int].reverse).distinct
    def numways(rem: Int, remCoins: List[Int]): Int = {
      //println(rem, remCoins)
      if (rem < 0) 0
      else if (remCoins.isEmpty && rem > 0) 0
      else if ((!remCoins.isEmpty) && rem == 0) 1
      else if (remCoins.length == 1 && rem % remCoins.head == 0) 1
      else numways(rem - remCoins.head, remCoins.tail) + numways(rem, remCoins.tail)
    }
    numways(money, sortedCoins) + 1
  };System.out.println("""countChange: (money: Int, coins: List[Int])Int""");$skip(435); 
  
  
    def countChange2(money: Int, coins: List[Int]): Int = {
    val sortedCoins = coins.sorted(Ordering[Int].reverse).distinct
    def numways(rem: Int, remCoins: List[Int]): Int = {
      println(rem, remCoins)
      if (rem == 0) 1
      else if (rem < 0) 0
      else if ((remCoins.isEmpty) && rem > 0) 0
      else numways(rem - remCoins.head, remCoins.tail) + numways(rem, remCoins.tail)
    }
    numways(money, coins)
  };System.out.println("""countChange2: (money: Int, coins: List[Int])Int""");$skip(49); val res$0 = 
  countChange2(300,List(500,5,50,100,20,200,10));System.out.println("""res0: Int = """ + $show(res$0))}
}
