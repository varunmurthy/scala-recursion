package recfun

import sun.misc.Sort

object recfun {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

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
  }                                               //> countChange: (money: Int, coins: List[Int])Int
  
  
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
  }                                               //> countChange2: (money: Int, coins: List[Int])Int
  countChange2(300,List(500,5,50,100,20,200,10))  //> (300,List(500, 5, 50, 100, 20, 200, 10))
                                                  //| (-200,List(5, 50, 100, 20, 200, 10))
                                                  //| (300,List(5, 50, 100, 20, 200, 10))
                                                  //| (295,List(50, 100, 20, 200, 10))
                                                  //| (245,List(100, 20, 200, 10))
                                                  //| (145,List(20, 200, 10))
                                                  //| (125,List(200, 10))
                                                  //| (-75,List(10))
                                                  //| (125,List(10))
                                                  //| (115,List())
                                                  //| (125,List())
                                                  //| (145,List(200, 10))
                                                  //| (-55,List(10))
                                                  //| (145,List(10))
                                                  //| (135,List())
                                                  //| (145,List())
                                                  //| (245,List(20, 200, 10))
                                                  //| (225,List(200, 10))
                                                  //| (25,List(10))
                                                  //| (15,List())
                                                  //| (25,List())
                                                  //| (225,List(10))
                                                  //| (215,List())
                                                  //| (225,List())
                                                  //| (245,List(200, 10))
                                                  //| (45,List(10))
                                                  //| (35,List())
                                                  //| (45,List())
                                                  //| (245,List(10))
                                                  //| (235,List())
                                                  //| (245,List())
                                                  //| (295,List(100, 20, 200, 10))
                                                  //| (195,List(20, 200, 10))
                                                  //| (175,List(200, 10))
                                                  //| (-25,List(10))
                                                  //| (175,List(10))
                                                  //| (165,List())
                                                  //| (175,List())
                                                  //| (195,List(200, 10))
                                                  //| (-5,List(10))
                                                  //| (195,List(10))
}