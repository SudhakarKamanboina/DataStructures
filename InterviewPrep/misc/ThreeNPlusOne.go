// Asked in Cisco (AppDynamics)
/*
 * even: n -> n/2
 * odd:  n -> 3*n + 1
 *
 * 1: 0
 * 2 -> 1: 1
 * 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1: 7
 * 4 -> 2 -> 1: 2
 * 5 -> 16 -> 8 -> 4 -> 2 -> 1: 5
 * 6 -> 3 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1: 8
 *
 * threeNPlusOne(1): 0
 * threeNPlusOne(2): 1
 * threeNPlusOne(3): 7
 * threeNPlusOne(4): 2
 *

// Follow - Up
* m -> length of the longest 3N+1 sequence for all numbers between 1 and m
 * fun(1): 0 (max(for i=1..1 threeNPlusOne(i)))
 * fun(2): 1 (max(for i=1..2 threeNPlusOne(i)))
 * fun(3): 7 (max(for i=1..3 threeNPlusOne(i)))
 * fun(4): 7 (max(for i=1..4 threeNPlusOne(i)))
 * fun(5): 7
 * fun(6): 8
 */

package main

import "fmt"
//import "math"

var m map[int]int


func main() {
  m = make(map[int]int)
  var max int



  for i := 1; i <= 5; i++ {
    threeNPlusOne(i)
    if (max < m[i]){
      max = m[i]
    }
  }
  fmt.Println("map:", m)
  for i := 1; i <= 5; i++ {
    if (max < m[i]){
      max = m[i]
    }
  }
  fmt.Println("input %v : result %v", 5, max)

}

func threeNPlusOne(num int) int {
  var step int;

  if (num <= 1) {
    return step
  }

  if ((num % 2) == 0) {
    if val, ok := m[num/2]; ok {
      step = val
    }else {
      step = threeNPlusOne(num/2)
    }

  }else {
    if val, ok := m[3 * num + 1]; ok {
      step = val
    }else {
      step = threeNPlusOne( 3 * num + 1)
    }

  }


  m[num] = step+1;
  return step +1;
}
