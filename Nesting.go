package solution

// you can also use imports, for example:
// import "fmt"
// import "os"

// you can write to stdout for debugging purposes, e.g.
// fmt.Println("this is a debug message")

func Solution(S string) int {
    //Not implementing a stack so we will just use a slice
    bracketSize := 0;

    for _, value := range S{
        if '(' == value{
            bracketSize++
        }else if( ')' == value && bracketSize > 0){
            bracketSize--
        }else{
            return 0
        }
    }

    if(bracketSize == 0){
        return 1
    }else{
        return 0
    }
}
