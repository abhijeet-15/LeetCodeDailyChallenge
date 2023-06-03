package June;

// 1376 https://leetcode.com/problems/time-needed-to-inform-all-employees/

//dfs
class Solution {
    
    private int maxTime;
    
    private void dfs(Map<Integer, List<Integer>> adj, int[] informTime, int u, int currTime) {
        maxTime = Math.max(maxTime, currTime);
        
        for(int v : adj.getOrDefault(u, new ArrayList<>())) {
            dfs(adj,informTime,v,currTime+informTime[u]);
        }
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.maxTime = Integer.MIN_VALUE;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        //create the graph O(N)
        for(int i=0; i<manager.length; i++) {
            int u = manager[i];
            int v = i;
            
            // u --> v
            adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
        }
        
        dfs(adj,informTime,headID,0);
        return maxTime;
        
    }
}

//bfs
class Pair {
    int first;
    int second;
    
    Pair(int _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}

class Solution {
     
    private int bfs(Map<Integer, List<Integer>> adj, int[] informTime, int i) {
        int maxTime = Integer.MIN_VALUE;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i,0));
        
        while(!q.isEmpty()) {
            int u = q.peek().first;
            int currTime = q.peek().second;
            q.poll();
            maxTime = Math.max(maxTime, currTime);
            
            for(int v : adj.getOrDefault(u,new ArrayList<>())) {
                q.offer(new Pair(v, currTime+informTime[u]));
            }
        }
        
        return maxTime;
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        //create the graph O(N)
        for(int i=0; i<manager.length; i++) {
            int u = manager[i];
            int v = i;
            
            // u --> v
            if(manager[i] != -1)
                adj.computeIfAbsent(u,k->new ArrayList<>()).add(v);
        }
        
        return bfs(adj,informTime,headID);
        
    }
}