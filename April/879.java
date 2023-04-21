//https://leetcode.com/problems/profitable-schemes/

class Solution {
    
    private int mod;
    
    private int solve(int n, int minProfit, int[] group, int[] profit, int dp [][][], int i, int used, int p) {
        
        if(i == group.length) {
            return p >= minProfit ? 1 : 0;
        }
        
        if(dp[i][used][p] != -1) {
            return dp[i][used][p];
        }
        
        //either you can take a group or not take a group and try to form the profit
        int take = 0, notTake = 0;
        
        if(used + group[i] <= n)
            take = solve(n, minProfit, group, profit, dp, i+1, used+group[i], Math.min(minProfit, p+profit[i]));
        
        notTake = solve(n, minProfit, group, profit, dp, i+1, used, p);
        
        return dp[i][used][p] = ( take + notTake) % mod;
        
    }
    
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        
        this.mod = 1000000007;
        
        int dp[][][] = new int [101][101][101];
        
        for(int[][] ddp : dp) {
            for(int[] d : ddp) {
                Arrays.fill(d, -1);
            }
        }
        
        return solve(n, minProfit, group, profit, dp, 0, 0, 0);
    }
}