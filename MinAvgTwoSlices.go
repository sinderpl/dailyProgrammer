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
