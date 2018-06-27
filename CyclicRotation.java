/**
An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is moved to the first place. For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).

The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.

Assume that the following declarations are given:

struct Results {
  int * A;
  int N; // Length of the array
};

Write a function:

struct Results solution(int A[], int N, int K);

that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given

    A = [3, 8, 9, 7, 6]
    K = 3
the function should return [9, 7, 6, 3, 8]. Three rotations were made:

    [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
    [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
    [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
For another example, given

    A = [0, 0, 0]
    K = 1
the function should return [0, 0, 0]

Given

    A = [1, 2, 3, 4]
    K = 4
the function should return [1, 2, 3, 4]

Assume that:

N and K are integers within the range [0..100];
each element of array A is an integer within the range [−1,000..1,000].
In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
**/

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int[] solution(int[] A, int K) {
       int[] result = new int[A.length];
       
       //Used for recursive return
       if(K < 1 || A.length == 0){
           return A;
       }
       else{
           //Move the last number to the first positon
           result[0] = A[A.length-1];
           int counter = 1;
           //Iterate through each value except for the last one in the original array
           //And assign the values one space further in the resulting array
           for(int x = 0; x < A.length -1; x++){
               result[counter] = A[x];
               counter++;
           }
           
           //Call the function recursively
           result = solution(result, K -1);
       }
       
       
       return result;
    }
}
