object HelloWorld {
  
    
    def twoSum(param1: List[Int], param2: Int) = {
        val gb = ((param1 combinations 2 toList) find (_.sum == param2) get)
        val gb2 = gb map (param1.indexOf(_)) sorted
        val index1 = gb2(0)+1
        val index2 = gb2(1)+1
        println(s" index1 = ${index1}, index2 = ${index2}")
    }
    

   def main(args: Array[String]) {
        val input: List[Int] = List(1,2,3,4,5,6,7,8,9)
        twoSum(input,8)
   }
}
