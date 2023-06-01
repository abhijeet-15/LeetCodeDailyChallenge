// 1091 https://leetcode.com/problems/shortest-path-in-binary-matrix/

//1091

// bfs
class Pair {
    int first;
    int second;
    
    Pair(int _x, int _y) {
        this.first = _x;
        this.second = _y;
    }
}

class Solution {
    
    private int m;
    private int n;
    
    private boolean isSafe(int i, int j) {
        
        if(i<0 || i>=m || j<0 || j>=n) return false;
        return true;
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0] == 1) return -1;
        
        this.m = grid.length;
        this.n = grid[0].length;
        int [][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}, {-1,-1},{1,1},{1,-1},{-1,1}};
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,0));
        grid[0][0] = 1;
        
        int level = 0;
        
        while(!q.isEmpty()) {
            int N = q.size();
            while(N-- > 0) {
                Pair p = q.peek();
                q.poll();
                int x = p.first;
                int y = p.second;
                
                if(x==m-1 && y==n-1) return level+1;
                
                for(int[] dir : directions) {
                    int x_ = x + dir[0];
                    int y_ = y + dir[1];
              
                    if(isSafe(x_,y_) && grid[x_][y_]==0) {
                        q.offer(new Pair(x_,y_));
                        grid[x_][y_] = 1;
                    }
                }
            }
            level++;
        }
        return -1;
    }
}