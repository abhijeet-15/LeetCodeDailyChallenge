// https://leetcode.com/problems/minimum-cost-for-tickets/

class Solution {
    
    private int solve(int days[], int costs[], Set<Integer> st, int dp[], int idx) {
        
        if(idx > 365) return 0;
        
        if(dp[idx] != -1) return dp[idx];
        
        if(st.contains(idx)) {
            
            int op1 = costs[0] + solve(days,costs,st,dp,idx+1);
            
            int op2 = costs[1] + solve(days,costs,st,dp,idx+7);
            
            int op3 = costs[2] + solve(days,costs,st,dp,idx+30);
            
            return dp[idx] = Math.min(op1, Math.min(op2, op3));
            
        }
        
        else {
            
            return dp[idx] = solve(days,costs,st,dp,idx+1);
            
        }
        
    }
    
    public int mincostTickets(int[] days, int[] costs) {
        
        Set<Integer> st = new HashSet<>();
        int dp[] = new int[366];
        
        for(int day : days) {
            
            st.add(day);
            
        }
        
        Arrays.fill(dp,-1);
        
        return solve(days,costs,st,dp,0);
        
    }
}