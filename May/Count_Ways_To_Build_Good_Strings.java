/*
 * 2466
 * https://leetcode.com/problems/count-ways-to-build-good-strings/
 */

 // Rec + Memo
 class Solution {
    
    private int mod;
    
    private int solve(int zero, int one, int[] dp, int n) {
        
        if(n == 0) {
            return 1;
        }
        
        if(n < 0) {
            return 0;
        }
        
        if(dp[n] != -1) {
            return dp[n];
        }
        
        int appendZero = solve(zero,one,dp,n-zero) % mod;
        int appendOne = solve(zero,one,dp,n-one) % mod;
        
        return dp[n] = (appendZero + appendOne) % mod;
    }
    
    public int countGoodStrings(int low, int high, int zero, int one) {
        this.mod = 1000000007;
        int count = 0;
        int[] dp = new int[high+1];
        Arrays.fill(dp, -1);
        
        for(int i=low; i<=high; i++) {
            count = (count + (solve(zero,one,dp,i)%mod))%mod;
        }
        
        return count;
    }
}

// Another Memo way
class Solution {
    private int mod;
    
    private int solve(int low, int high, int zero, int one, int[] dp, int l) {
        
        if(l > high) {
            return 0;
        }
        
        if(dp[l] != -1) {
            return dp[l];
        }
        
        int addOne = 0;
        
        if(l >= low && l <=high) {
            addOne = 1;
        }
        
        int appendZero =  solve(low,high,zero,one,dp,l+zero) % mod;
        int appendOne =  solve(low,high,zero,one,dp,l+one) % mod;
        
        return dp[l] =  (addOne + appendZero + appendOne) % mod;
    }
    
    public int countGoodStrings(int low, int high, int zero, int one) {
        this.mod = 1000000007;
        int[] dp = new int[high + 1];
        Arrays.fill(dp, -1);
        return solve(low, high, zero, one, dp, 0);
    }
}