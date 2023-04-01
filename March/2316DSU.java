//https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/submissions/

class Solution {
    
    private int parent[];
    private int rank[];
    
    int find(int x) {
        
        if(parent[x] == x) return parent[x];
        
        return parent[x] = find(parent[x]);
    }
    
    void Union(int x, int y) {
        
        //find parents
        int x_parent = find(x);
        int y_parent = find(y);
        
        // if same parent no need to merge
        if(x_parent == y_parent) return;
        
        if(rank[x_parent] > rank[y_parent]) {
            parent[y_parent] = x_parent;
        }
        
        else if(rank[x_parent] < rank[y_parent]) {
            parent[x_parent] = y_parent;
        }
        
        else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
        
    }
    
    
    public long countPairs(int n, int[][] edges) {
        
        this.parent = new int[n];
        this.rank = new int[n];
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        // step - 2 --> making components
        for(int[] edge: edges) {
            
            int u = edge[0];
            int v = edge[1];
            
            Union(u,v);
            
        }
        
        // step 3 - map of parent and its size
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            
            int papaji = find(i);
            
            map.put(papaji, map.getOrDefault(papaji,0)+1);
            
        }
        
        // step 4 --> find result from map
        
        long result = 0;
        long remainingNodes = n;
        
        //loop in the map
        for(int it: map.values()) {
            
            long size = it;
            
            result += (size) * (remainingNodes - size);
            remainingNodes -= size;
            
        }
        
        return result;
        
    }
}