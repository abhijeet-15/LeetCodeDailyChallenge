// https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/

class Solution {
    
    private int mini;
    
    private void dfs(int u, Map<Integer, List<Pair>> adj, boolean[] visited) {
        
        if(!adj.containsKey(u)) return;
        
        visited[u] = true;
        
        for(Pair edge: adj.get(u)) {
            
            int v = edge.first;
            int c = edge.second;
            
            mini = Math.min(mini, c);
            
            if(!visited[v]) {
                dfs(v,adj,visited);
            }
        }
    }
    
    public int minScore(int n, int[][] roads) {
        
        mini = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n+1];
        
        Map<Integer, List<Pair>> adj = new HashMap<>();
        
        
        for(int[] road : roads) {
            
            int u = road[0];
            int v = road[1];
            int d = road[2];
            
            adj.computeIfAbsent(u, k-> new ArrayList<>()).add(new Pair(v, d));
            adj.computeIfAbsent(v, k-> new ArrayList<>()).add(new Pair(u,d));
            
        }
        
        dfs(1,adj,visited);
        
        return mini;
    
    }
}

class Pair {
    int first;
    int second;
    
    Pair(int _first, int _second) {
        
        this.first = _first;
        this.second = _second;
    }
}