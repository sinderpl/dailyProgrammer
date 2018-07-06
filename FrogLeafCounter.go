package solution

// you can also use imports, for example:
// import "fmt"
// import "os"

// you can write to stdout for debugging purposes, e.g.
// fmt.Println("this is a debug message")

func Solution(X int, A []int) int {

    value := 0;
    var leafPresent = make([]bool, X+1)
    
    for index,_ := range A{
        if !leafPresent[value] && value <= X{
            leafPresent[value] = true
            value++
        }
        if value == X{
            return index
        }
    }
    
    return -1
}
