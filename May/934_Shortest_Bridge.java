class Pair {
    int row;
    int col;
    
    Pair(int _row, int _col) {
        row = _row;
        col = _col;
    }
    
    @Override
   public int hashCode() {
      int hash = 3;
      hash = 47 * hash + this.row;
      hash = 47 * hash + this.col;
      return hash;
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      final Pair other = (Pair) obj;
      if (this.row != other.row) {
         return false;
      }
      if (this.col != other.col) {
         return false;
      }
      return true;
   }
}

class Solution {
    
    private int m;
    private int n;
    
    private int[][] directions = {
                 {-1,0},
        {0,-1},            {0,1},
                {1,0}
    };
    
    private boolean isSafe(int i, int j) {
        if(i<0 || i>=m || j<0 || j>=n){
            return false;
        }
        return true;
    }
    
    private void dfs(int i, int j, int[][] grid, Set<Pair> visitedCells) {
        
        if(!isSafe(i,j) || grid[i][j] == 0 || visitedCells.contains(new Pair(i,j))) {
            return;
        }
        
        visitedCells.add(new Pair(i,j));

        for(int[] dir : directions) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];
            
            dfs(i_,j_,grid,visitedCells);
        }
        
    }
    
    private int bfs(int[][] grid, Set<Pair> visitedCells) {
        
        Queue<Pair> q = new LinkedList<>();
        for(Pair p : visitedCells) {
            q.offer(p);
        }
        
        int level = 0;
        while(!q.isEmpty()) {
            int L = q.size();
            while(L-- > 0) {
                Pair pair = q.poll();
                int x = pair.row;
                int y = pair.col;
                
                for(int[] dir : directions) {
                    int x_ = x + dir[0];
                    int y_ = y + dir[1];
                    
                    Pair p_ = new Pair(x_,y_);
                    if(isSafe(x_,y_) && !visitedCells.contains(p_)) {
                        if(grid[x_][y_] == 1) return level;
                        visitedCells.add(p_);
                        q.offer(p_);       
                    }     
                }
            }
            
            level++;
        }
        return level;
    }
    
    public int shortestBridge(int[][] grid) {
        
        this.m = grid.length;
        this.n = grid[0].length;
        Set<Pair> visitedCells = new HashSet<>();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    dfs(i,j,grid,visitedCells);
                    return bfs(grid,visitedCells);
                }
            }
        }
        return 0;
    }
}