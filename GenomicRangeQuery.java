/**
A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

For example, consider string S = CAGCCTA and arrays P, Q such that:

    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
The answers to these M = 3 queries are as follows:

The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
Write a function:

class Solution { public int[] solution(String S, int[] P, int[] Q); }

that, given a non-empty string S consisting of N characters and two non-empty arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.

The sequence should be returned as:

a Results structure (in C), or
a vector of integers (in C++), or
a Results record (in Pascal), or
an array of integers (in any other programming language).
For example, given the string S = CAGCCTA and arrays P, Q such that:

    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
the function should return the values [2, 4, 1], as explained above.

Assume that:

N is an integer within the range [1..100,000];
M is an integer within the range [1..50,000];
each element of arrays P, Q is an integer within the range [0..N − 1];
P[K] ≤ Q[K], where 0 ≤ K < M;
string S consists only of upper-case English letters A, C, G, T.
Complexity:

expected worst-case time complexity is O(N+M);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).


**/

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    
    //Uses prefix sums which are totals of all numbers before them
    //Based on : https://stackoverflow.com/questions/19552754/java-codility-training-genomic-range-query
    //My solution was less elegant, this helped me understand the problem
    public int[] solution(String S, int[] P, int[] Q) {
        //Calculate the prefix sums
        //Only need three as if none are matched then we are 
        int [][] prefixSums = new int[3][S.length()+1];
        
        
        int a ,c , g;
        //Calculates the prefix sums for the genomes
        for(int x  = 0 ; x < S.length(); x++)
        {
            a = 0;
            c = 0;
            g = 0;
            
            //Increase the corresponding counters
            if('A' == (S.charAt(x)))
            {
                a++;
            }
            if('C' == (S.charAt(x)))
            {
                c++;   
            }
            if('G' == (S.charAt(x)))
            {
                g++;
            }
            
            //Increase the prefix sums for ALL locations regardless if they were incremented
            prefixSums[0][x+1] = prefixSums[0][x] + a;
            prefixSums[1][x+1] = prefixSums[1][x] + c;
            prefixSums[2][x+1] = prefixSums[2][x] + g;
        }
        
        int[] minimalImpact = new int[P.length];
        
        
        for(int x = 0; x < P.length ; x++)
        {
            int beginIndex = P[x];
            int endIndex = Q[x]+1;
            
            if(prefixSums[0][endIndex] - prefixSums[0][beginIndex] > 0) //checks A
            {
                minimalImpact[x] = 1;
            }
            else if(prefixSums[1][endIndex] - prefixSums[1][beginIndex] > 0) //Checks C
            {
                minimalImpact[x] = 2;
            }
            else if(prefixSums[2][endIndex] - prefixSums[2][beginIndex] > 0) //Checks G
            {
                minimalImpact[x] = 3;
            }
            else //If Other ones are ignored the default is the largest T
            {
                minimalImpact[x] = 4;
            }
        }
        
        return minimalImpact;
    }
}
