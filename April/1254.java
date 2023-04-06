// https://leetcode.com/problems/number-of-closed-islands/

// dfs

class Solution {
    
    private int m;
    private int n;
    
    private boolean dfs(int grid[][], int i, int j) {
        
        //check for boundary
        
        if(i<0 || i>=m || j<0 || j>= n) {
            
            return false;
            
        }
        
        if(grid[i][j] == 1) {
            
            return true; // is side se closed hain
            
        }
        
        //mark visited
        grid[i][j] = 1;
        
        // charo dishao me check kr lo ab
        
        boolean leftClosed = dfs(grid,i,j-1);
        
        boolean rightClosed = dfs(grid,i,j+1);
        
        boolean upClosed = dfs(grid,i-1,j);
        
        boolean downClosed = dfs(grid,i+1,j);
        
        return leftClosed && rightClosed && upClosed && downClosed;
        
    }
    
    public int closedIsland(int[][] grid) {
        
        this.m = grid.length;
        this.n = grid[0].length;
        
        int count = 0;
        
        for(int i=0; i<m; i++) {
            
            for(int j=0; j<n; j++) {
                
                if(grid[i][j] == 0) {
                    
                    if(dfs(grid,i,j)) {
                        
                        count++;
                    }
                }
                
            }
        }
        
        return count;
    }
}