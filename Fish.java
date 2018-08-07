// you can also use imports, for example:
// import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A, int[] B) {
        int deadFish = 0;
        Queue<Integer> downStream = new LinkedList();
        for(int x = 0 ;  x  < A.length; x++)
        {
            if(B[x] == 1)
            {
                downStream.add(A[x]);
            }
            else if(B[x] == 0 && downStream.size() >= 1)
            {
                boolean currentFishDefeated = false;
                while(!downStream.isEmpty() && !currentFishDefeated)
                {
                    if(A[x] < downStream.peek())
                    {
                        currentFishDefeated = true;
                    }
                    else
                    {
                        downStream.poll();
                    }
                    deadFish ++;
                    if(downStream.isEmpty())
                    {
                        currentFishDefeated = true;
                    }
                }
                
            }
            
        }
        return A.length - deadFish;
    }
}
