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