// https://leetcode.com/problems/restore-the-array/

// using Rec + Memo
class Solution {
    
    private int mod;
    
    private int solve(String s, int dp[], int idx, int k) {
        
        if(idx == s.length()) {
            
            return 1;
        }
        
        if(s.charAt(idx) == '0') {
            
            return 0;
        }
        
        if(dp[idx] != -1) {
            
            return dp[idx];
        }
        
        int count = 0;
        
        for(int i = idx; i < s.length(); i++) {
            
            String curr = s.substring(idx, i+1);
            
            if(Long.parseLong(curr) > k) {
                break;
            }
            
            count = (count + solve(s,dp,i+1,k)) % mod;
            
        }
        
        return dp[idx] =  count;
        
    }
    
    public int numberOfArrays(String s, int k) {
        
        int n = s.length();
        int dp[] = new int [n+1];
        Arrays.fill(dp,-1);
        
        this.mod = 1000000007;
        
        return solve(s,dp,0,k);
        
        
    }
}