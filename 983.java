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


// bottom up

class Solution {
    
    public int mincostTickets(int[] days, int[] costs) {  
         
        Set<Integer> st = new HashSet<>();
        
        for(int day : days) {           
            st.add(day);         
        }
        
        int lastDay = days[days.length - 1];
        
        int dp[] = new int[lastDay+1];
        
        //dp[i] = min cost required to travel till i th day of your travel plan
        
        dp[0] = 0;
        
        for(int i=1; i<=lastDay; i++) {
            
            // check if you have to travel on the ith day
            
            if(!st.contains(i)) {
                
                dp[i] = dp[i-1];
                continue;
                
            }
            
            int day1pass = costs[0] + dp[Math.max(i-1, 0)];
            
            int day7pass = costs[1] + dp[Math.max(i-7, 0)];
            
            int day30pass = costs[2] + dp[Math.max(i-30,0)];
            
            dp[i] = Math.min(day1pass, Math.min(day7pass, day30pass));
            
            
        }
        
        return dp[lastDay];
        
    }
}