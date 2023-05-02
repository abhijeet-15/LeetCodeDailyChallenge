// https://leetcode.com/problems/sign-of-the-product-of-an-array/

// TC O(N) and space is O(1)
class Solution {
    
    public int arraySign(int[] nums) {
        int countNegative = 0;
        
        for(int n : nums) {
            if(n == 0) return 0;
            if(n < 0) countNegative++;
        }
        
        countNegative = countNegative % 2;
        
        return countNegative == 0 ? 1 : -1;
    }
}