package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {//change to 22 to check pascal if out of Int range
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    //everytime mutiply a little num in case of overflow Int range
	def factB(c: Int, r: Int): Int =if (c==0) 1 else factB(c-1,r)*(r-c+1)/c
	factB(c,r)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean ={
  	def count(char:Char):Int ={
  		if (char == '(') 1
  		else if (char == ')') -1
  		else 0
  	}
  	def isOK(len:Int,chars:List[Char]):Boolean={
  		if (chars.isEmpty) len==0
  		else if (len==0 && count(chars.head) == -1) false
  		else isOK(len+count(chars.head),chars.tail)
  	}
  	isOK(0,chars)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int =
		if (money==0) 1
		else if (coins.isEmpty || money<0) 0
		else countChange(money,coins.tail)+countChange(money-coins.head,coins)
}




def balance(chars: List[Char], open: Int): Boolean = {
  if (chars.isEmpty)
    open == 0
  else if (chars.head == '(')
    balance(chars.tail, open + 1)
  else if (chars.head == ')' && open > 0)
    // found an unmatched '(' earlier
    balance(chars.tail, open - 1)
  else
    balance(chars.tail, open)
}                                                 
  
val x = "(x + y + (z + 1)))"                    
balance(x.toList, 0)
  
val y = "())("
balance(y.toList, 0)




