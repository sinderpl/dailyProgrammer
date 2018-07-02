/**
An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Assume that:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
**/

//does not work for large numbers
class Solution {
    public int solution(int[] A) {
        int result;
        
        //Sums up the supposed total of the first numbers from 1..N
        result = (A.length+1)*(A.length+2)/2;
        
        //Remove each number in the array to get the missing number
        for(int x = 0; x<A.length; x++)
        {
            result -= A[x];
        }
        
        //Missing number
        return result;
    }
}

//faster bitwise operation

    public int solution(int[] A) {
        int x1 = A[0];
        int x2 = 1;
        
        //XOR all elements in the original array
        for(int x = 1; x < A.length; x++)
        {
            x1 ^= A[x];
        }
        
        //XOR all elements from 1 to N + 1
        for(int x = 2; x <= A.length + 1; x++)
        {
            x2 ^= x;
        }
        
        //Find and return the XOR of X1 and X2
        return x1 ^ x2;
    }
}
