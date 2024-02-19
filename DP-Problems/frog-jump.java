//problem link -->  https://www.codingninjas.com/studio/problems/frog-jump_3621012

import java.util.* ;
import java.io.*; 
public class Solution {
    public static int frogJump(int n, int heights[]) {
        int prev = 0;
        int prev2 = 0;
       for(int i =1;i < n;i++){
           int left = prev + Math.abs(heights[i] - heights[i-1]);
           int right = Integer.MAX_VALUE;
           if(i > 1){
               right = prev2 + Math.abs(heights[i] - heights[i-2]);
           }

           int cur = Math.min(left,right);
           prev2 = prev;
           prev = cur;
       }

       return prev;
    }

   
}