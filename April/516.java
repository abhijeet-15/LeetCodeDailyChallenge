// https://leetcode.com/problems/longest-palindromic-subsequence/

//Approach 1 : using LCS logic

class Solution {
    
    private int solve(String s1, String s2, int dp[][], int i, int j) {
        
        if(i == s1.length() || j == s2.length()) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        //match
        if(s1.charAt(i) == s2.charAt(j)) {
            
            return dp[i][j] = 1 + solve(s1,s2,dp,i+1,j+1);
            
        }
        
        //no match
        else {
            
            return dp[i][j] = Math.max(solve(s1,s2,dp,i+1,j), solve(s1,s2,dp,i,j+1));
        }
        
    }
    
    public int longestPalindromeSubseq(String s1) {     
        StringBuilder s2 = new StringBuilder(s1);
        s2.reverse();
        
        int dp[][] =  new int[s1.length()+1][s1.length()+1];
        for(int[] d : dp)
            Arrays.fill(d,-1);
        
        return solve(s1,s2.toString(),dp,0,0);
        
    }
}