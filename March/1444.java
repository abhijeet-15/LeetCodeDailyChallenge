// https://leetcode.com/problems/number-of-ways-of-cutting-a-pizza/

class Solution {
    
    private int m, n;
    private int[][] apples;
    private int[][][] dp;
    
    int mod = 1000000007;
    
    private int solve(int i, int j, int k) {
        
        if(apples[i][j] < k)
            return 0;
        
        if(k==1) {
            
            if(apples[i][j] >= 1)
                return 1;
            
            return 0;
        }
        
        if(dp[i][j][k] != -1) return dp[i][j][k];
        
        int ans = 0;
        
        //horizontal cut 
        for(int h= i+1; h<m; h++) {
            
            int lowerSliceApples = apples[h][j];
            int upperSliceApples = apples[i][j] - lowerSliceApples;
            
            if(upperSliceApples >=1 && lowerSliceApples >= k-1) {
                
                ans = (ans % mod + solve(h,j,k-1) % mod) % mod;
                
            }
            
            
        }
        
        //vertical cut 
        for(int v= j+1; v<n; v++) {
            
            int rightSliceApples = apples[i][v];
            int leftSliceApples = apples[i][j] - rightSliceApples;
            
            
            if(leftSliceApples >=1 && rightSliceApples >= k-1) {
                
                ans = (ans % mod + solve(i,v,k-1) % mod) % mod;
                
            }
            
            
        }
        
        return dp[i][j][k] = ans; 
        
    }
    
    
    public int ways(String[] pizza, int k) {
        
        this.m = pizza.length;
        this.n = pizza[0].length();
        
        this.apples = new int[51][51]; 
        this.dp = new int[51][51][11];
        
        for(int[][] dd : dp) {
            for(int[] d : dd) {
                Arrays.fill(d,-1);
            }
        }
        
        
        // make apples array
        //apple[i][j] = number of apples in pizza from i,j to m-1, n-1 2d grid
        for(int i=m-1; i >=0; i--) {
            
            for(int j=n-1; j >=0; j--) {
                
                apples[i][j] = apples[i][j+1];
                
                for(int l=i; l<m; l++) {
                    
                    if(pizza[l].charAt(j) == 'A')
                        apples[i][j] += 1;
                    
                }
                
            }
            
        }
        
        return solve(0,0,k);
    }
}