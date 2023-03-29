// https://leetcode.com/problems/reducing-dishes/

class Solution {
    
    int solve(int satisfaction[], int dp[][], int idx, int time) {
        
        
        if(idx == satisfaction.length) {
            
            return 0;
            
        }
        
        if(dp[idx][time] != -1) {
            
            return dp[idx][time];
        }
        
        int take = satisfaction[idx] * time + solve(satisfaction, dp, idx+1, time+1);
        
        int notTake = 0 + solve(satisfaction, dp, idx+1, time);
        
        return dp[idx][time] = Math.max(take, notTake);
        
        
    }
    
    public int maxSatisfaction(int[] satisfaction) {
        
        Arrays.sort(satisfaction);
        
        int dp[][] = new int[satisfaction.length+1][satisfaction.length+1];
        
        for(int[] d : dp)
            Arrays.fill(d,-1);
        
        return solve(satisfaction, dp, 0, 1);
    }
}


// bottom up  tabulation

class Solution {
    
    public int maxSatisfaction(int[] satisfaction) {
        
        int n = satisfaction.length;
        
        Arrays.sort(satisfaction);
        
        long dp[][] = new long[n+1][n+1];
        
        for(long[] d : dp)
            Arrays.fill(d, Integer.MIN_VALUE);
        
        //dp[i][j] = max value till 0...i and time is j currently
        
        // at time 0, we have no values
        
        for(int i=0; i<n+1; i++) {
            
            dp[i][0] = 0;
            
        }
        
        //cooking started
        
        dp[0][1] = satisfaction[0];
        
        for(int i=1; i<n; i++) {
            
            for(int t=1; t<n+1; t++) {
                
                long include = satisfaction[i] * t + dp[i-1][t-1];
                
                long exclude = 0 + dp[i-1][t];
                
                dp[i][t] = Math.max(include, exclude);
                
            }
            
        }
        
        // question asks the max value could be at any time so can't return dp[n][n] blindly
        
        long ans = 0;
        
        for(int i=0; i<n+1; i++) {
            
            ans = Math.max(ans, dp[n-1][i]);
            
        }
        
        return (int) ans;
    }
}