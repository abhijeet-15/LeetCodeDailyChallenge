//https://leetcode.com/problems/last-day-where-you-can-still-cross/
// tc O(row*col*log(row*col)) SC O(row*col)
// binary search + bfs
class Pair {
    int first;
    int second;
    
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    
    int[][] directions = {{-1,0}, {1,0} , {0,-1}, {0,1}};
    
    boolean bfs(int row, int col, int[][] cells, int day) {
        
        int[][] grid = new int[row][col];
        
        for(int i=0; i<day; i++) {
            int x = cells[i][0]-1;
            int y = cells[i][1]-1;
            grid[x][y] = 1;
        }
        
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<col; i++) {
            if(grid[0][i] == 0) {
                q.offer(new Pair(0,i));
                grid[0][i] = -1;
            }
        }
        
        while(!q.isEmpty()) {
            int x = q.peek().first;
            int y = q.peek().second;
            q.poll();
            
            if(x == row-1) {
                return true;
            }
            
            for(int[] dir : directions) {
                int x_ = x + dir[0];
                int y_ = y + dir[1];
                
                if(x_>=0 && x_<row && y_>=0 && y_<col && grid[x_][y_]==0) {
                    q.offer(new Pair(x_,y_));
                    grid[x_][y_] = -1;
                }
            }
        }
        return false;
    }
    
    public int latestDayToCross(int row, int col, int[][] cells) {
        int s = 1;
        int e = row*col;
        int mid;
        int ans = 0;
        while(s < e) {
            mid = s + (e-s)/2;
            if(bfs(row,col,cells,mid)) {
                ans = mid;
                s = mid+1;
            }
            else {
                e = mid;
            }
        }
        return ans;
    }
}