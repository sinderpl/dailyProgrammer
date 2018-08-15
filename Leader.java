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

class Solution {
    public int solution(int[] A) 
    {
        //Pretty cool solution since in a way it utilises its own stack
        int occurence = 0;
        int candidate = 0;
        
        //First we find the number which could potentially be the leader
        for(int x = 0 ; x < A.length; x++)
        {
            //Get the initial value onto the stack
            if(occurence == 0)
            {
                candidate = A[x];
                occurence++;
            }
            else
            {
                //Otherwise we compare if the value on stack is the same as the current candidate
                if(A[x] == candidate)
                {
                    occurence++;
                }
                else
                {
                    occurence--;
                }
            }
        }
        //If candidate is not present reset the value
        if (occurence < 1)
        {
            candidate = 0;
        }
        
        //Verify that the number does in fact occur in more than half the indexes
        int indexOfLeader = 0;
        occurence = 0;
        
        for(int x = 0; x < A.length; x++)
        {
            if(A[x] == candidate)
            {
                occurence++;
                indexOfLeader = x;
            }
        }
        
        return occurence > (A.length / 2) ? indexOfLeader : -1;
    }
}
