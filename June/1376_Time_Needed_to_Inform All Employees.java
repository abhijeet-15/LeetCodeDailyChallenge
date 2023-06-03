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

1376_Time_Needed_to_Inform All Employees.java