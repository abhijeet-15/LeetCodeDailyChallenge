// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
// O(n) Time and space

class Solution {
    
    private int n;
    private int[][] t;
    private int fee;
    
    private int solve(int[] prices, int idx, int buy) {
        if(idx >= n) return 0;
        if(t[idx][buy] != -1) return t[idx][buy];
        
        int profit = 0;
        if(buy == 1) {
            int consider = solve(prices,idx+1,0) - prices[idx];
            int notConsider = solve(prices,idx+1,1);
            profit = Math.max(profit, Math.max(consider, notConsider));
        }
        else {
            int consider = solve(prices,idx+1,1) + prices[idx] - fee;
            int notConsider = solve(prices,idx+1,0);
            profit = Math.max(profit, Math.max(consider, notConsider));
        }
        
        return t[idx][buy] = profit;
    }
    
    public int maxProfit(int[] prices, int fee) {
        
        this.n = prices.length;
        this.t = new int[n+1][2];
        for(int[] tt : t)
            Arrays.fill(tt,-1);
        this.fee = fee;
        
        return solve(prices,0,1);
    }
}