/**
A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Assume that:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).

**/
// you can also use imports, for example:
// import java.util.*;
import java.util.Stack;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(String S) {
        Stack<String> brackets = new Stack<>();
        
        for (String bracket : S.split(""))
        {
            if("(".equals(bracket) || "{".equals(bracket) || "[".equals(bracket))
            {
                brackets.push(bracket);
            }
            else if (")".equals(bracket) && brackets.size() > 0 && "(".equals(brackets.peek()))
            {
                brackets.pop();
            }
            else if ("}".equals(bracket) && brackets.size() > 0 && "{".equals(brackets.peek()))
            {
                brackets.pop();
            }
            else if ("]".equals(bracket) && brackets.size() > 0 && "[".equals(brackets.peek()))
            {
                brackets.pop();
            }
            else
            {
                return 0;
            }
        }
        
        
        return brackets.size() == 0 ? 1 : 0;
    }
}
