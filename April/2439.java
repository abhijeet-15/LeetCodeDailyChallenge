// https://leetcode.com/problems/minimize-maximum-of-array/

class Solution {
    
    private boolean isValid(int nums[], int mid, int n) {
        
        if(nums[0] > mid) return false; // nums[0] ko kum toh kr skte ni
        
        long prev = nums[0];
        
        for(int i = 1; i < nums.length; i ++) {
            
            long buffer = mid - prev;
            
            if(nums[i] - buffer > mid) return false;
            
            prev = nums[i] - buffer;
        }
        
        return true;
    } 
    
    public int minimizeArrayValue(int[] nums) {
        
        int n = nums.length;
        
        int s = 0;
        int e = 0;
        
        int result = e;
        
        for(int i=0; i<n; i++) {
            e = Math.max(nums[i], e);
        }
        
        while(s <= e) {
            
            int mid = s + (e-s)/2;
            
            if(isValid(nums,mid,n)) {
                
                result = mid;
                
                e = mid-1;
                       
            }
            
            else {
                
                s = mid + 1;
                
            }
            
        }
        
        return result;
    }
}