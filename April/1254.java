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


// bfs

class Pair {
    
    int first;
    int second;
    
    Pair(int _first, int _second) {
        
        this.first = _first;
        
        this.second = _second;
        
    }
    
}


class Solution {
    
    private int m;
    private int n;
    
    private boolean bfs(int grid[][], int i, int j) {
        
        boolean isClosed = true;
        
        Queue<Pair> q = new LinkedList<>();
        
         if(i>=m || i<0 || j>=n || j<0) {
            
            return false; // out of bound, not closed

        }
        
        q.offer(new Pair(i, j));
        
        //mark visited
        grid[i][j] = 1;
        
        int[] dirx = {0, 1, 0, -1};
        int[] diry = {-1, 0, 1, 0};
        
        while(!q.isEmpty()) {
            
            Pair p = q.peek();
            
            q.poll();
            
            int x = p.first;
            int y = p.second;
            
            for (int k = 0; k < 4; k++) {
    
                int new_x = x + dirx[k];
                int new_y = y + diry[k];
                
                if (new_x < 0 || new_x >= m || new_y < 0 || new_y >= n) {
                   
                    isClosed = false;
                    
                } 
                
                else if (grid[new_x][new_y] == 0) {
                    
                    q.offer(new Pair(new_x, new_y));
                    
                    grid[new_x][new_y] = 1;
                    
                }
            }
        }
        
        return isClosed;
        
        
    }
    
    
    public int closedIsland(int[][] grid) {
        
        this.m = grid.length;
        this.n = grid[0].length;
        
        int count = 0;
        
        for(int i=0; i<m; i++) {
            
            for(int j=0; j<n; j++) {
                
                if(grid[i][j] == 0) {
                    
                    if(bfs(grid,i,j)) {
                        
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}