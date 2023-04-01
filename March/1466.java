// https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/submissions

// dfs

class Solution {
    
    private int count;
    
    void dfs(int u, int parent, Map<Integer, List<Pair>> adj) {
        
        if(!adj.containsKey(u)) return;
        
        for(Pair P : adj.get(u)) {
            
            int v = P.first;          
            int check = P.second;
            
            if(v != parent) {
                
                if(check == 1) {
                    count++; // 0 se dur ja rhe h
                }
                
                dfs(v,u,adj);
            }
        }
        
    }
    
    public int minReorder(int n, int[][] connections) {
        
        count = 0;
        
        Map<Integer, List<Pair>> adj = new HashMap<>();
        
        for(int[] connection : connections) {
            
            int u = connection[0];
            int v = connection[1];
            
            adj.computeIfAbsent(u, k->new ArrayList<>()).add(new Pair(v,1)); // asli
            adj.computeIfAbsent(v, k->new ArrayList<>()).add(new Pair(u,0)); // nakli
            
        }
        
        dfs(0,-1, adj);
        
        return count;
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