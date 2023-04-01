// https://leetcode.com/problems/number-of-zero-filled-subarrays/
// https://leetcode.com/problems/number-of-zero-filled-subarrays/discuss/3323131/Recursive-Relation-with-Diagram-Java-C%2B%2B


class Solution {
      
    private long solve(int n) {
        
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        return n + solve(n-1);
    }
    
    public long zeroFilledSubarray(int[] nums) {
        
        long ans = 0;
        int count = 0;
        int size = nums.length;
    
        for(int i=0; i<size; i++) {
            
            if(nums[i] == 0) {
                count++;
            }
            
            else if(nums[i] != 0) {
                
                if(count != 0)
                    ans += solve(count);
                
                count = 0;
            }
        }
        
       if(count != 0) {
           ans += solve(count);
           count = 0;
       }
        
        return ans;

    }
}