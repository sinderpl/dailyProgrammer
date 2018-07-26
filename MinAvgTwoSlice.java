// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        //Bit of help from stack overflow as I wasnt sure how prefix sums fit into this
        //Apparently they dont...
        int result = 0;
        double minimumAverage = (A[0] + A[1])/2;
        
        double currentAverage = 0.0;
        
        for(int x = 0; x < A.length-2; x++)
        {
            
            //Check two element slices
            currentAverage = ((double)(A[x] + A[x + 1]))/2;
            if(currentAverage < minimumAverage)
            {
                minimumAverage = currentAverage;
                result = x;
            }
            
            //Check three element slices
            currentAverage = ((double)(A[x] + A[x + 1] + A[x + 2]))/3;
            if(currentAverage < minimumAverage)
            {
                minimumAverage = currentAverage;
                result = x;
            }
        }
        
        //Check final two elements
        currentAverage = ((double) (A[A.length-2] + A[A.length-1])) / 2;
        if(currentAverage < minimumAverage)
        {
            result = A.length-2;
        }
        
        return result;
    }
}
