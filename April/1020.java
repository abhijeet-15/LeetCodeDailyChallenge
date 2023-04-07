// https://leetcode.com/problems/number-of-enclaves/

//dfs

class Solution {
    
    private int m;
    private int n;
    
    private void dfs(int grid[][], int i, int j) {
        
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j] == 0) {
            
            return;
            
        }
        
        grid[i][j] = 0; // mark visited
        
        dfs(grid, i, j-1);
        
        dfs(grid, i, j+1);
        
        dfs(grid, i-1, j);
        
        dfs(grid, i+1, j);
        
    }
    
    
    public int numEnclaves(int[][] grid) {
        
        this.m = grid.length;
        this.n = grid[0].length;
        
        int count = 0;
        
        for(int i=0; i<m; i++) {
            
            if(grid[i][0] == 1) {
                
                dfs(grid,i,0);
            }
            
            if(grid[i][n-1] == 1) {
                
                dfs(grid,i,n-1);
                
            }
            
        }
        
        for(int i=0; i<n; i++) {
            
            if(grid[0][i] == 1) {
                
                dfs(grid,0,i);
            }
            
            if(grid[m-1][i] == 1) {
                
                dfs(grid,m-1,i);
                
            }
            
        }
        
        for(int i=0; i<m; i++) {
            
            for(int j=0; j<n; j++) {
                
                if(grid[i][j] == 1) {
                    
                    ++count;
                    
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
        
        first = _first;
        second = _second;
    }
    
}


class Solution {
    
    private int m;
    private int n;
    
   private void bfs(int grid[][], int i, int j) {
       
       if(i<0 || i>=m || j<0 || j>=n) {
           
           return;
           
       }
       
       Queue<Pair> q = new LinkedList<>();
       
       q.offer(new Pair(i, j));
       grid[i][j] = 0;
       
       while(!q.isEmpty()) {
           
           Pair P = q.peek();
           q.poll();
           
           int x = P.first;
           int y =P.second;
           
           int dirx[] = {0,1,0,-1};
           int diry[] = {-1,0,1,0};
           
           for(int k=0; k<4; k++) {
               
               int new_x = x + dirx[k];
               int new_y = y + diry[k];
               
               if(new_x<0 || new_x>=m || new_y<0 || new_y>=n) {
                   
                   continue;
               }
               
               else if(grid[new_x][new_y] == 1) {
                   
                   q.offer(new Pair(new_x, new_y));
                   
                   grid[new_x][new_y] = 0;
                   
               }
               
           }
           
       }
       
       return;
   }
    
    
    public int numEnclaves(int[][] grid) {
        
        this.m = grid.length;
        this.n = grid[0].length;
        
        int count = 0;
        
        for(int i=0; i<m; i++) {
            
            if(grid[i][0] == 1) {
                
                bfs(grid,i,0);
            }
            
            if(grid[i][n-1] == 1) {
                
                bfs(grid,i,n-1);
                
            }
            
        }
        
        for(int i=0; i<n; i++) {
            
            if(grid[0][i] == 1) {
                
                bfs(grid,0,i);
            }
            
            if(grid[m-1][i] == 1) {
                
                bfs(grid,m-1,i);
                
            }
            
        }
        
        for(int i=0; i<m; i++) {
            
            for(int j=0; j<n; j++) {
                
                if(grid[i][j] == 1) {
                    
                    ++count;
                    
                }
                
            }
            
        }
        
        return count;
    }
}