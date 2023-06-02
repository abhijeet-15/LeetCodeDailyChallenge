package June;

// 2101 https://leetcode.com/problems/detonate-the-maximum-bombs/

//dfs
class Solution {
    
    private double findDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));
    }
    
    private int dfs( Map<Integer, List<Integer>> adj, boolean[] visited, int u) {
        visited[u] = true;
        int count = 1;
        if(!adj.containsKey(u)) return count;
        for(int v : adj.get(u)) {
            if(!visited[v]) {
                count += dfs(adj,visited,v);
            }
        }
        return count;
    }
    
    public int maximumDetonation(int[][] bombs) { 
        Map<Integer, List<Integer>> adj = new HashMap<>();
        boolean[] visited;
        int n = bombs.length;
        
        //build the graph
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j) continue;
                double distance = findDistance(bombs[i][0],bombs[i][1], bombs[j][0], bombs[j][1]);
                if((bombs[i][2] * 1.0) >= distance) {
                    //edge i->j
                    adj.computeIfAbsent(i,k->new ArrayList<>()).add(j);
                }
            }
        }
        
        int answer = 0;
        //from each node find the maximum nodes that can be visited
        for(int i=0; i<n; i++) {
            visited = new boolean[n];
            int count = dfs(adj,visited,i);
            answer = Math.max(answer,count);
        }
        return answer;
    }
}

// bfs
class Solution {

    private int BFS(Map<Integer, List<Integer>> adj, int i) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(i);
        visited.add(i);
   
        while(!q.isEmpty()) {
            int u = q.peek();
            q.poll();
            
            //if(!adj.containsKey(u)) return visited.size();
            
            for(int v : adj.getOrDefault(u, new ArrayList<>())) {
                if(!visited.contains(v)) {
                    q.offer(v);
                    visited.add(v);
                }
            }
        }
        return visited.size();
    }
    
    public int maximumDetonation(int[][] bombs) { 
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int n = bombs.length;
        
        //build the graph
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                
                if(i == j) continue;
                long x1 = bombs[i][0];
                long y1 = bombs[i][1];
                long r1 = bombs[i][2];

                
                long x2 = bombs[j][0];
                long y2 = bombs[j][1];
                long r2 = bombs[j][2];
                
                long distance = (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);
                
                if((long)(r1*r1) >= distance) {
                    //edge i->j
                    adj.computeIfAbsent(i,k->new ArrayList<>()).add(j);
                }
            }
        }
        
        int result = 0;
        
        //from each node find the maximum nodes that can be visited
        for(int i = 0; i<n; i++) {
            int count = BFS(adj,i);
            result = Math.max(result, count);
        }     
       return result;      
    }
}