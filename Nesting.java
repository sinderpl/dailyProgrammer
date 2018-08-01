/**
A string S consisting of N characters is called properly nested if:

S is empty;
S has the form "(U)" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Assume that:

N is an integer within the range [0..1,000,000];
string S consists only of the characters "(" and/or ")".
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
**/
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    
    //Not valid and not great solution, forgot to use stacks
    public int solution(String S) {
        if (S.length() <= 1)
        {
            return 0;
        }
        int leftBracket = 0;
        int rightBracket = 0;
        for(String c : S.split(""))
        {
            if("(".equals(c))
            {
                leftBracket++;
            }
            else if(")".equals(c))
            {
                rightBracket++;
            }
        }
        
        return leftBracket==rightBracket ? 1 : 0;
    }
    //THe actual solution
    public int solution(String S) 
    {
        Stack<Character> brackets = new Stack<>();
        
        //Iterate over the brackets
        for(int x = 0; x < S.length(); x++)
        {
            if(S.charAt(x) == '(')
            {
                //Adds the bracket to the stack
                brackets.push('(');
            }
            else if(S.charAt(x) == ')' && brackets.size() > 0)
            {
                //If matching opening bracket was found pop the stack
                brackets.pop();
            }
            else
            {
                //If a clsoing bracket had no opening bracket to match
                //then the String is not properly nested
                return 0;
            }
        }
        
        return brackets.size() == 0 ? 1: 0;
    }
}
