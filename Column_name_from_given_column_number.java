// GFG problem
// Link: https://practice.geeksforgeeks.org/problems/column-name-from-a-given-column-number4244/1

// Solution:

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}
// } Driver Code Ends

class Solution
{
    String colName (long n)
    {
        // your code here
        String op = "";
        char alpha[] = new char[26];
        alpha[0] = 'A';
        for (int i = 1; i < 26; i++)
            alpha[i] = (char) ((int) alpha[i - 1] + 1);
        
        while (n > 0)
        {
            long rem = (n - 1) % 26;
            op = alpha[(int) rem] + op;
            n = (n - 1) / 26; 
        }
        return op;
    }
}
