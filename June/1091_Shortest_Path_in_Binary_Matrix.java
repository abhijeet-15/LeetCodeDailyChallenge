package June;

// 1091 https://leetcode.com/problems/shortest-path-in-binary-matrix/

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

// Dijakstra
class Triple {
    int first;
    int second;
    int third;
    
    Triple(int _w, int _x, int _y) {
        this.first = _w;
        this.second = _x;
        this.third = _y;
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
       
        int[][] result = new int[m][n];
        for(int[] res: result)
            Arrays.fill(res,Integer.MAX_VALUE);
        
        result[0][0] = 0;
        
        PriorityQueue<Triple> pq = new PriorityQueue<Triple>((x,y) -> x.first - y.first);
        pq.add(new Triple(0,0,0));
        
        while(pq.size() != 0) {
            int d = pq.peek().first;
            int x = pq.peek().second;
            int y = pq.peek().third;       
            pq.remove();
            
            for(int[] dir : directions) {
                int x_ = x + dir[0];
                int y_ = y + dir[1];             
                int dist = 1;
                
                if(isSafe(x_,y_) && grid[x_][y_]==0 && d+dist<result[x_][y_]) {
                    pq.add(new Triple(d+dist,x_,y_));
                    result[x_][y_] = d+dist;
                }
            }
        }
        
        if(result[m-1][n-1] == Integer.MAX_VALUE) return -1;
        return result[m-1][n-1] + 1;
        
    }
}