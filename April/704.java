// https://leetcode.com/problems/binary-search/

// iterative

class Solution {
    
    public int search(int[] nums, int target) {
        
        int s=0;
        int e = nums.length - 1;
        
        int mid = -1;
        
        while(s <= e) {
            
            mid = s + (e-s)/2;
            
            if(nums[mid] == target) {
                
                return mid;
                
            }
            
            else if(nums[mid] > target) {
                
                e = mid-1;
                
            }
            
            else {
                
                s = mid+1;
                
            }
            
        }
        
        return -1;
        
    }
}


// recursive

class Solution {
    
    private int bSearch(int nums[], int target, int s, int e) {
        
        if(s > e) return -1;
        
        int mid = s + (e-s)/2;
        
        if(nums[mid] == target) return mid;
        
        if(nums[mid] > target) {
            
            return bSearch(nums,target,s,mid-1);
            
        }
        
        return bSearch(nums,target,mid+1,e);
        
    }
    
    public int search(int[] nums, int target) {
        
        return bSearch(nums,target,0,nums.length-1);
    }
    
}

