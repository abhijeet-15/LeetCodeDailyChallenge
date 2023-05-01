// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/

/*
 time complexity O(N) where N = salary.length
 space complexity O(1)
 */

class Solution {
    public double average(int[] salary) {
        int maxi =  Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
        
        double sum = 0;
        
        for(int s : salary) {
            
            if(s < mini) mini = s;
            if(s > maxi) maxi = s;
            
            sum += s;
        }
    
        return (sum-mini-maxi)/(salary.length - 2);
    }
}