package main

import (
	"fmt"
)

func minDistance(a string, b string) int {
	s1 := len(a)
	s2 := len(b)

	if s1 == 0 {
		return s2
	} else if s2 == 0 {
		return s1
	}
    t1 := s1 + 1
    t2 := s2 + 1
	w := make ([][]int, t1)
	for i := 0; i < t1; i++ {
		w[i] = make([]int, t2)
		for j := 0; j < t2; j++ {
			if i == 0 {
				w[i][j] = j
			} else if j == 0{
				w[i][j] = i
			} else {
				w[i][j] = 0;
			}
		}
	}
//fmt.Println(w[0:6]) 

	for i := 1; i <= s1; i++ {
		for j := 1; j <= s2; j++ {		
			w[i][j] = min(w[i-1][j]+1, w[i][j-1]+1 );
			if a[i-1] == b[j-1] {
				w[i][j] = min(w[i-1][j-1], w[i][j])
			} else {
				w[i][j] = min(w[i-1][j-1]+1, w[i][j])
			}
		}
	} 

	return w[s1][s2]
}

func min(a, b int) int {
   if a < b {
      return a
   }
   return b
}

func main() {
	var x string = "hello"
	var y string = "world"

	distance := minDistance(x,y)
	fmt.Println(distance)
}
