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