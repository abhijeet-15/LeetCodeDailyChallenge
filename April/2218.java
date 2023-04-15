// https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/

//Approach 1 Rec + Memo
class Solution {
    private int n;
    private int dp[][];
    
    private int solve(List<List<Integer>> piles, int i, int k) {
        
        if(i >= n)
            return 0;
        
        if(dp[i][k] != -1)
            return dp[i][k];
        
        int notTaken = 0 + solve(piles,i+1,k);
        
        int taken = 0;
        int sum = 0;
        
        for(int j=0; j<Math.min(piles.get(i).size(), k); j++) {
            sum += piles.get(i).get(j);
            
            taken = Math.max(taken, sum+solve(piles,i+1,k-(j+1)));
            
        }
        
        return dp[i][k] = Math.max(taken, notTaken);
        
    }
    
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        this.n = piles.size();
        this.dp = new int[n+1][k+1];
        
        for(int[] d : dp) 
            Arrays.fill(d,-1);
        
        return solve(piles,0,k);
    }
}

//Approach 2 Bottom up 
class Solution {
    
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        int dp[][] = new int[n+1][k+1];
        
        //dp[i][j] = Max value when we have i piles and max coin we can take is j
        
        for(int i=1; i<n+1; i++) {
            
            for(int coins=0; coins<k+1; coins++) {
                
                int sum = 0;
                
                for(int currCoins = 0; currCoins<=Math.min(piles.get(i-1).size(), coins); currCoins++) {
                    
                    if(currCoins > 0)
                        sum += piles.get(i-1).get(currCoins-1);
                    
                    dp[i][coins] = Math.max(dp[i][coins], sum+dp[i-1][coins-currCoins]);
                    
                }
            }
            
        }
        
        return dp[n][k];
    }
}