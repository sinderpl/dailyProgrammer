/**
Write a function

func Solution(A []int) int

that, given an array A consisting of N integers, returns the number of distinct values in array A.

Assume that:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
For example, given array A consisting of six elements such that:

 A[0] = 2    A[1] = 1    A[2] = 1
 A[3] = 2    A[4] = 3    A[5] = 1
the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).

**/
package solution

// you can also use imports, for example:
// import "fmt"
// import "os"
import "sort"
// you can write to stdout for debugging purposes, e.g.
// fmt.Println("this is a debug message")

func Solution(A []int) int {
    dist := 0
    sort.Ints(A)
    
    for x := 1; x < len(A); x++{
        if A[x] == A[x-1]{
            dist++
        }         
    }
    
    return len(A) - dist
}
