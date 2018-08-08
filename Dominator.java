/**

An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

For example, consider array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

Assume that:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
For example, given array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
the function may return 0, 2, 4, 6 or 7, as explained above.

Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).


**/
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
