/**
A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.

For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the number of its factors.

For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.

Assume that:

N is an integer within the range [1..2,147,483,647].
Complexity:

expected worst-case time complexity is O(sqrt(N));
expected worst-case space complexity is O(1).
**/

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

/**
 *  More optimized than a simple for loop which evaluates to O(N) this is the O(sqrt(N)) solution 
**/
class Solution {
    public int solution(int N) {
        int totalDivisors = 0;
        int currentNumber = 1;
        
        while(currentNumber * currentNumber < N)
        {
            if(N % currentNumber == 0)
            {
                //In this case there obviously is two numbers eg 3 * 4 = 12
                totalDivisors += 2;
            }
            currentNumber ++;
        }
        
        //Appends the final number 
        if(currentNumber * currentNumber == N)
        {
            totalDivisors += 1;
        }
        
        return totalDivisors;
    }
}

