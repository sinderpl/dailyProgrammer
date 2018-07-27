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
