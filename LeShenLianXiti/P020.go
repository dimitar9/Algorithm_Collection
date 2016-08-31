package main

import "fmt"
import "math"

func main(){
   coins := []float64{1,8,5,66}
   fmt.Println(maxValue(coins))
}
func maxValue(coins []float64) float64{
    size := len(coins)
    dp := make([][]float64, size)
    for i:=0; i < size; i++ {
        dp[i] = make([]float64, size)
    }
    //if the length of available coins is 1. just chose it.
    for i:= 0; i < size; i++ {
        dp[i][i] =coins[i]
    }
    // if the length of available coins is 2, pick larger one
    for i:= 0; i+1 < size; i++ {
        dp[i][i+1] = math.Max(coins[i], coins[i+1])
    }
    for t := 3; t <= size; t++ {
        for i := 0; i + t - 1 < size; i++{
            j := i + t - 1
            pickHead := coins[i] + math.Min(dp[i+2][j], dp[i+1][j-1])
            pickTail := coins[j] + math.Min(dp[i][j-2], dp[i+1][j-1])
            dp[i][j] = math.Max(pickHead, pickTail)
        }
    }
    return dp[0][size-1]
}
