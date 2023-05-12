/*
 * 2140
 * https://leetcode.com/problems/solving-questions-with-brainpower/
 * 
 */

 // Rec + Memo
 class Solution {
    
    private int n;
    
    private long solve(int[][] q, long[] dp, int idx) {
        
        if(idx >= n) {
            return 0;
        }
        
        if(dp[idx] != -1) {
            return dp[idx];
        }
        
        long take = q[idx][0] + solve(q,dp,idx+q[idx][1]+1);
        
        long notTake = 0 + solve(q,dp,idx+1);
        
        return dp[idx] = Math.max(take, notTake);
        
    }
    
    public long mostPoints(int[][] questions) {
        this.n = questions.length;
        
        long dp[] = new long[n+1];
        Arrays.fill(dp, -1);
        
        return solve(questions,dp,0);
    }
}