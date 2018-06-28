
/**
A non-empty array A consisting of N integers is given. The array contains an odd number of elements, and each element of the array can be paired with another element that has the same value, except for one element that is left unpaired.

For example, in array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the elements at indexes 0 and 2 have value 9,
the elements at indexes 1 and 3 have value 3,
the elements at indexes 4 and 6 have value 9,
the element at index 5 has value 7 and is unpaired.
Write a function:

int solution(int A[], int N);

that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

For example, given array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the function should return 7, as explained in the example above.

Assume that:

N is an odd integer within the range [1..1,000,000];
each element of array A is an integer within the range [1..1,000,000,000];
all but one of the values in A occur an even number of times.
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
**/


// import java.util.*;
import java.util.ArrayList;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        
        int result = 0;
        int largest = 0;
        
        //Find the largest value for our array size
        for(int x=0; x<A.length; x++){
            if(A[x] > largest){
                largest = A[x];
            }
        }
        
        //Initialize the largest value as size of array
        int[] occurenceArray =  new int[largest+1];
        
        //Iterate through each number and map to a corresponding map with value as index
        for(int x = 0; x < A.length ; x ++ ){
            occurenceArray[A[x]] += 1;
        }
        //Iterate through the resulting array
        for(int x=0; x<occurenceArray.length; x++){
            if(occurenceArray[x] != 0 && occurenceArray[x] % 2 != 0){
                return x;
            }   
        }
        
        return result;
        
    }
  
  //Not the most readable but apparently the most optimal solution using XOR
  //#TODO need to revise bitwise operations
  public int solution(int[] A) {
        
       // write your code in Java SE 8
		int elem = 0;

		for (int i = 0; i < A.length; i++) {
			elem ^= A[i];
		}
		return elem;
        
    }
  
}
