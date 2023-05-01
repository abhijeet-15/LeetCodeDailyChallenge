// https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/

//DSU

class DSU {
      
    int[] parent;
    int[] rank;
    int components;
    
    DSU(int n) {
        
        this.parent = new int[n+1];
        this.rank = new int[n+1];
        components = n;
        
        
        for(int i=1; i<n+1; i++) {
            parent[i] = i;
        }
    }
    
    
    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public void Union(int x, int y) {
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
        
        components--;
    }
    
    boolean isSingleComponent() {
        return components == 1;
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        
        DSU Alice = new DSU(n);
        DSU Bob = new DSU(n);
        
        Arrays.sort(edges, (a,b)->b[0]-a[0]);
        int edgeCount = 0;
        
        for(int[] edge : edges) {
            
            int type =  edge[0];
            int u = edge[1];
            int v = edge[2];
            
            if(type == 3){            
                boolean edgeKraYaNi = false;
                
                //Alice   
                if(Alice.find(u) != Alice.find(v)) {
                    Alice.Union(u,v);
                    edgeKraYaNi = true;
                }
                
                //Bob
                if(Bob.find(u) != Bob.find(v)) {
                    Bob.Union(u,v);
                    edgeKraYaNi = true;
                }
                
                if(edgeKraYaNi) edgeCount++;
            }
            
            else if(type == 2) {
                
                if(Bob.find(u) != Bob.find(v)) {
                    Bob.Union(u,v);
                    edgeCount++;
                }
            }
            
            else {
                if(Alice.find(u) != Alice.find(v)) {
                    Alice.Union(u,v);
                    edgeCount++;
            }
                
                
                
        }
        } 
        
        if(Alice.isSingleComponent() && Bob.isSingleComponent()) {
                return edges.length - edgeCount;
            }
            
            return -1;
    }
}