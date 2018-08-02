//#TODO this is not finished yet


package solution

// you can also use imports, for example:
// import "fmt"
// import "os"

// you can write to stdout for debugging purposes, e.g.
// fmt.Println("this is a debug message")

func Solution(S string) int {
    brackets := make([]rune, 0)
    currentPosition := -1
    
    for _,value := range S{
        if value == '(' || value == '{' || value == '['{
            brackets = append(brackets,value)
            currentPosition ++
        }else{
            if(isMatching(value ,brackets[currentPosition])){
                brackets = brackets[:currentPosition]
                currentPosition--
            }else{
                brackets = append(brackets,value)
                currentPosition ++
            }
        }
    }
    
    
    
    if len(brackets) == 0{
        return 1
    }else{
        return 0
    }
}


func isMatching(first rune, second rune) bool{
    isMatching := false
    
    if first == '(' && second == ')'{
        isMatching = true
    }else if first == '{' && second == '}'{
        isMatching = true
    }else if first == '[' && second == ']'{
        isMatching = true
    }
    
    return isMatching
}
