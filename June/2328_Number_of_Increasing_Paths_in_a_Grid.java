// https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/

// TC O(mn) SC O(mn)

class Solution {
    
    private int m;
    private int n;
    private int[][] t;
    private int mod = 1000000007;
    private int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    
    int solve(int[][] grid, int i, int j, int prev) {
        
        if(i<0 || i>=m || j<0 || j>= n || grid[i][j] <= prev) return 0;
        
        if(t[i][j] != -1) return t[i][j];
        
        long ans = 1;
        for(int[] dir : directions) {
            int x_ = i + dir[0];
            int y_ = j + dir[1];
            
            ans = (ans + (solve(grid,x_,y_,grid[i][j])%mod)%mod);
    
        }
        
        return t[i][j] = (int)ans;
    }
    
    public int countPaths(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.t = new int[m+1][n+1];
        for(int[] tt: t){
            Arrays.fill(tt,-1);
        }
        
        long res = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                res = ((res%mod) + solve(grid,i,j,0)%mod)%mod;
            }
        }
        return (int)res;       
    }
}