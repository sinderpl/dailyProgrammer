/**
An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

func Solution(A []int) int

that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Assume that:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).

**/

package solution

// you can also use imports, for example:
// import "fmt"
// import "os"

// you can write to stdout for debugging purposes, e.g.
// fmt.Println("this is a debug message")

func Solution(A []int) int {
    sortedArray := make([]int, len(A)+ 2)
    
    //Iterate through original array and map it to their index values in new array
    for x := 0; x < len(A) ; x++{
        sortedArray[A[x]] = 1        
    }
    
    //Iterate through new array and return the first value that is not present by checking for 1
    for x := 1; x < len(sortedArray) ; x++{
        if sortedArray[x] != 1{
            return x
        }
    }
    
    //Should not happen
    return -1
}
