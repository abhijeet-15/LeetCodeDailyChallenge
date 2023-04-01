// https://leetcode.com/problems/number-of-operations-to-make-network-connected/

// DSU

class Solution {
    
    private int[] parent;
    private int[] rank;
    
    private int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    private void Union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);
        
        if(x_parent != y_parent) {
            if(rank[x_parent] > rank[y_parent]) {
                parent[y_parent] = x_parent;
            }
            else if (rank[y_parent] > rank[x_parent]) {
                parent[x_parent] = y_parent;
            }
            else {
                parent[x_parent] = y_parent;
                rank[y_parent]++;
            }
        }                
    }
    
    
    public int makeConnected(int n, int[][] connections) {
                
        if(connections.length < n-1) return -1;
               
        this.parent = new int[n];
        this.rank = new int[n];
        
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        int components = n; //ilaka
            
            for(int[] connection : connections) {
                
                if(find(connection[0]) != find(connection[1])) {
                    
                    Union(connection[0], connection[1]);
                    
                    components--; // ilaka merge hue
                }
            }
        
        return components - 1;
    }
}