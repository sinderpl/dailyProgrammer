// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution 
{
    public int solution(int[] A) 
    {
        int current = 0;
        int size = 0;
        
        //Find the candidate for the dominator
        for (int x = 0; x < A.length; x++)
        {
            //Initially our candidate is the first value
            if (size == 0)
            {
                current = A[x];
                size++;
            }
            else
            {
                if(A[x] == current)
                {
                    size++;
                }
                else
                {
                    size--;
                }
            }
        }
        
        //Check whether the candidate occurs in more than 50% of the array
        int occurence = 0;
        int index = -1;
        for(int x = 0; x < A.length; x++)
        {
            if(A[x] == current)
            {
                occurence++;
                index = x;
            }
        }
        
        return occurence >  A.length / 2 ? index : -1;        
    }
}
