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

// Bottom up
class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        
        if(n == 1){
            return questions[0][0];
        }
        
        long[] dp = new long[200001];
        
        //dp[i] --> max points gained by Qns from i to n-1
        
        for(int i=n-1; i>=0; i--) {
            dp[i] = Math.max(questions[i][0] + dp[i + questions[i][1] + 1], dp[i+1]) ;
        }
        
        return dp[0];
    }
}