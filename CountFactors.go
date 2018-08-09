/**
A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.

For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).

Write a function:

func Solution(N int) int

that, given a positive integer N, returns the number of its factors.

For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.

Assume that:

N is an integer within the range [1..2,147,483,647].
Complexity:

expected worst-case time complexity is O(sqrt(N));
expected worst-case space complexity is O(1).

**/
package solution

// you can also use imports, for example:
// import "fmt"
// import "os"

// you can write to stdout for debugging purposes, e.g.
// fmt.Println("this is a debug message")

func Solution(N int) int {
    numberOfDivisors := 0
    currentNumber := 1
    
    for currentNumber * currentNumber < N{
        if(N % currentNumber == 0){
            numberOfDivisors += 2
        }
        currentNumber++
    }

    if(currentNumber * currentNumber == N){
        numberOfDivisors++   
    }
    
    return numberOfDivisors
}
