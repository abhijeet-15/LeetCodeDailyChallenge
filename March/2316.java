// https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/submissions/

// bfs

class Solution {
    
    private long bfs(int u, Map<Integer, List<Integer>> adj, boolean visited[]) {
        
        Queue<Integer> q = new LinkedList<>();      
        q.offer(u);
        
         long size = 1;
        
        visited[u] = true;
        
        while(!q.isEmpty()) {
            
            int x = q.poll();
            
            if(!adj.containsKey(x)) {
                continue;
            } 
            
            for(int v : adj.get(x)) {
                
                if(!visited[v]) {
                    
                    visited[v] = true;
                    
                    size++;
                    
                    q.offer(v);
                    
                }
                
            }
        }
        
        return size;
    }

    
    
    public long countPairs(int n, int[][] edges) {
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int[] edge : edges) {
            
            int u = edge[0];
            int v = edge[1];
            
            adj.computeIfAbsent(u, k->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k->new ArrayList<>()).add(u);
            
        }
        
        // visited
        boolean visited[] = new boolean[n];
        
        long remainingNodes = n;
        long result = 0;
        
        for(int i=0; i<n; i++) {
            
            if(!visited[i]) {
                
                long size = bfs(i, adj, visited);
                
                result += (size * (remainingNodes - size));
                
                remainingNodes -= size;
            }
        }
        
        return result;
    }
}



// dfs

class Solution {
    
    private long dfs(int u, Map<Integer, List<Integer>> adj, boolean visited[]) {
        
        long size = 1;
        
        visited[u] = true;
        
        if(!adj.containsKey(u)) return size;
        
        for(int v : adj.get(u)) {
            
            if(!visited[v]) {
                
                size += dfs(v, adj, visited);
            }
            
        }
        
        return size;
    }
    
    public long countPairs(int n, int[][] edges) {
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int[] edge : edges) {
            
            int u = edge[0];
            int v = edge[1];
            
            adj.computeIfAbsent(u, k->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k->new ArrayList<>()).add(u);
            
        }
        
        // visited
        boolean visited[] = new boolean[n];
        
        long remainingNodes = n;
        long result = 0;
        
        for(int i=0; i<n; i++) {
            
            if(!visited[i]) {
                
                long size = dfs(i, adj, visited);
                
                result += (size * (remainingNodes - size));
                
                remainingNodes -= size;
            }
        }
        
        return result;
    }
}