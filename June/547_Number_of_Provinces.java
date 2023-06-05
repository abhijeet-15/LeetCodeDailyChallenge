// 547 https://leetcode.com/problems/number-of-provinces/

// bfs
class Solution {
    
    private void bfs(int[][] isConnected, boolean[] visited, int i) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        visited[i] = true;
        
        while(!q.isEmpty()) {
            int u = q.peek();
            q.poll();
            for(int v=0; v<isConnected.length; v++) {
                if(isConnected[u][v] == 1 && !visited[v]) {
                    q.offer(v);
                    visited[v] = true;
                }
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        
        int count = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                count++;
                bfs(isConnected,visited,i);
            }
        }
        return count;
    }
}

//dfs
public class Solution {
    public void dfs(int[][] isConnected, boolean[] visited, int u) {
        for (int v = 0; v < isConnected.length; v++) {
            if (isConnected[u][v] == 1 && !visited[v]) {
                visited[v] = true;
                dfs(isConnected, visited, v);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int u = 0; u < isConnected.length; u++) {
            if (!visited[u]) {
                dfs(isConnected, visited, u);
                count++;
            }
        }
        return count;
    }
}

//dfs