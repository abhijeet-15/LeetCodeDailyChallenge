// https://leetcode.com/problems/minimum-path-sum/ 

class Solution {
    
    private int m;
    private int n;
    
    int solveMemo(int[][] grid, int[][] dp, int i, int j) {
        
        if(i == m-1 && j == n-1) return grid[i][j];
        
        if(i >= m || j >= n) return Integer.MAX_VALUE;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        return dp[i][j] = grid[i][j] + Math.min(solveMemo(grid,dp,i+1,j), solveMemo(grid,dp,i,j+1));
        
    }
    
    
    public int minPathSum(int[][] grid) {
        
        this.m = grid.length;
        this.n = grid[0].length;
        
        int[][] dp = new int[m][n];
        
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        
        return solveMemo(grid,dp,0,0);
        
    }
}