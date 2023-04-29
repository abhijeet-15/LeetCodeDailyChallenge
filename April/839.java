// https://leetcode.com/problems/similar-string-groups/

// DFS
class Solution {
    
    private boolean isSimilar(String s1, String s2) {
        int m = s1.length();
        int diff = 0;
        
        for(int i=0; i<m; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        
        return diff == 0 || diff == 2;
    }
    
    private void dfs(int u, Map<Integer, List<Integer>> adj, boolean visited[]) {
        
        visited[u] = true;
        
        if(!adj.containsKey(u))
            return;
        
        for(int v : adj.get(u)) {
            if(!visited[v]) {
                dfs(v,adj,visited);
            }
        }
    }
    
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(isSimilar(strs[i], strs[j])) {
                    adj.computeIfAbsent(i, k->new ArrayList<Integer>()).add(j);
                    adj.computeIfAbsent(j, k->new ArrayList<Integer>()).add(i);
                }
            }
        }
        
        boolean visited[] = new boolean[n];
        int count = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i,adj,visited);
                count++;
            }
        }
        
        return count;
    }
}

//BFS
class Solution {
    
    private boolean isSimilar(String s1, String s2) {
        int m = s1.length();
        int diff = 0;
        
        for(int i=0; i<m; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        
        return diff == 0 || diff == 2;
    }
    
   private void bfs(int i, Map<Integer, List<Integer>> adj, boolean visited[]) {
       Queue<Integer> q = new LinkedList<>();
       
       q.offer(i);
       visited[i] = true;
       
       while(!q.isEmpty()) {
           
           int u = q.peek();
           q.poll();
           
           for(int v : adj.get(u)) {
               
               if(!adj.containsKey(v))
                   continue;
               
               if(!visited[v]) {
                   q.offer(v);
                   visited[v] = true;
               }
           }
       }
   }
    
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(isSimilar(strs[i], strs[j])) {
                    adj.computeIfAbsent(i, k->new ArrayList<Integer>()).add(j);
                    adj.computeIfAbsent(j, k->new ArrayList<Integer>()).add(i);
                }
            }
        }
        
        boolean visited[] = new boolean[n];
        int count = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                bfs(i,adj,visited);
                count++;
            }
        }
        
        return count;
    }
}

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
    
    private boolean isSimilar(String s1, String s2) {
        
        int m = s1.length();
        int diff = 0;
        for(int i=0; i<m; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
        }
        
        return diff == 0 || diff == 2;
    }
    
    public int numSimilarGroups(String[] strs) {
        
        int n = strs.length;
        
        this.parent = new int[n];
        this.rank = new int[n];
        
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        int groupCount = n;
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                
                if(isSimilar(strs[i], strs[j]) && find(i) != find(j)) {
                    Union(i,j);
                    groupCount--;
                }
            }
        }
        
        return groupCount;
    }
}