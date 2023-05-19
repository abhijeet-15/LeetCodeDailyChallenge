/*
 * https://leetcode.com/problems/is-graph-bipartite/
 */

 // DFS
 class Solution {
    
    private boolean checkBipartiteDFS(int[][] adj, int u, int[] color, int currColor) {
        
        color[u] = currColor;
        
        for(int v : adj[u]) {
            if(color[v] == color[u]){
                return false;
            }
            if(color[v] == -1) {
                if(!checkBipartiteDFS(adj,v,color, 1-currColor)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isBipartite(int[][] adj) {
        
        int n = adj.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        
        for(int i=0; i<n; i++) {
            if(color[i] == -1) {
                if(!checkBipartiteDFS(adj,i,color,1)){
                    return false;
                }     
            }
        }
        return true;
    }
}

//BFS
class Solution {
    
    private boolean checkBipartiteBFS(int[][] adj, int node, int[] color, int currColor) {
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        color[node] = currColor;
        
        while(!q.isEmpty()) {
            int u = q.peek();
            q.poll();
            
            for(int v : adj[u]) {
                if(color[v] == color[u]){
                    return false;
                }
                else if(color[v] == -1){
                    color[v] = 1-color[u];
                    q.offer(v);
                }
            }
        }
        return true;
    }
    
    public boolean isBipartite(int[][] adj) {
        int n = adj.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        
        for(int i=0; i<n; i++) {
            if(color[i] == -1){
                if(!checkBipartiteBFS(adj,i,color,1)){
                    return false;
                }
            }
        }
        return true;
    }
}