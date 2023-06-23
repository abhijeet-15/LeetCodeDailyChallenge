// 1027 https://leetcode.com/problems/longest-arithmetic-subsequence/

// TC O(n^2) SC O(n^2)

//rec + memo
class Solution {
    
    private int t[][];
    private int n;
    
    int solve(int[] nums, int idx, int diff) {
        if(idx >= n) return 0;
        if(t[idx][diff+501] != Integer.MIN_VALUE) return t[idx][diff+501];
        int maxi = 1;
        
        if(diff == -501) {
            for(int i=idx+1; i<n; i++) {
                maxi = Math.max(maxi, Math.max(1+solve(nums,i,nums[i]-nums[idx]), solve(nums,i,diff)));
            }
        }
        else {
            for(int i=idx+1; i<n; i++) {
                if(nums[i] - nums[idx] == diff) {
                    maxi = Math.max(maxi,1+solve(nums,i,diff));
                    break;
                }
            }
        }
        return t[idx][diff+501] = maxi;
    }
    
    public int longestArithSeqLength(int[] nums) {
        n = nums.length;
        t = new int[1005][1005];
        for(int[] tt : t)
            Arrays.fill(tt, Integer.MIN_VALUE);
        return solve(nums,0,-501);
    }
}