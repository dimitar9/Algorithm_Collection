object HelloWorld {
  
   def reverse(s: String): String = {
      // return s.split(" ").map(x => x.reverse).mkString(" ")
        return s.split(" ").reverse.mkString(" ") 
   }
  

   def main(args: Array[String]) {
      println("Hello, world!")
      println(reverse("hello worrd"))
   }
}

