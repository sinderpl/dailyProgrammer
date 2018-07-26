/**
A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

For example, array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
contains the following example slices:

slice (1, 2), whose average is (2 + 2) / 2 = 2;
slice (3, 4), whose average is (5 + 1) / 2 = 3;
slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
The goal is to find the starting position of a slice whose average is minimal.

Write a function:

func Solution(A []int) int

that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

For example, given array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
the function should return 1, as explained above.

Assume that:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−10,000..10,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
**/
package solution

// you can also use imports, for example:
// import "fmt"
// import "os"
import "fmt"
// you can write to stdout for debugging purposes, e.g.
// fmt.Println("this is a debug message")

func Solution(A []int) int {
    result := 0
    minimumAverageValue := 0.0
    currentAverage := 0.0
    
    minimumAverageValue = float64((A[0] + A[1]))/2
    
    for index := 0 ; index < len(A)-2; index++{
        //Check slices of length two
        currentAverage = float64((A[index] + A[index+1]))/2
        if currentAverage < minimumAverageValue{
            fmt.Println("trigg")
            minimumAverageValue = currentAverage
            result = index
        }
        //Check slices of length 3
        currentAverage = float64((A[index] + A[index+1] + A[index+2]))/3

        if currentAverage < minimumAverageValue{
            minimumAverageValue = currentAverage
            result = index
            fmt.Println(result)
        }
    }
    
    //Check final two indexes
    currentAverage = float64((A[len(A)-2] + A[len(A)-1])/2)
    if currentAverage < minimumAverageValue{
        fmt.Print("nah")
        result = len(A)-2
    }
    return result
}
