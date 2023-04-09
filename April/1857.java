// https://leetcode.com/problems/largest-color-value-in-a-directed-graph/

class Solution {
    
    public int largestPathValue(String colors, int[][] edges) {
        
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        
        int N = colors.length();
        int indegree[] = new int[N];
        
        for(int[] edge: edges) {
            
            int u = edge[0];
            int v = edge[1];
            
            adj.computeIfAbsent(u, k->new ArrayList<Integer>()).add(v);
            
            indegree[v]++;
            
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        int dp[][] = new int[N][26];
        
        for(int i=0; i<N; i++) {
            
            if(indegree[i] == 0) {
                
                q.offer(i);
                
                dp[i][colors.charAt(i) - 'a'] = 1;
                
            }
            
        }
        
        int answer = 0;
        int seenNodesCount = 0;
        
        while(!q.isEmpty()) {
            
            int u = q.peek();
            q.poll();
            
            seenNodesCount++;
            
            answer = Math.max(answer, dp[u][colors.charAt(u) - 'a']);
            
            if(!adj.containsKey(u))
                continue;
            
            for(int v : adj.get(u)) {
                
                for(int i=0; i<26; i++) {
                    
                    dp[v][i] = Math.max(dp[v][i], dp[u][i] + ((colors.charAt(v) - 'a') ==  i ? 1 : 0));
                    
                }
                
                
                indegree[v]--;

                if(indegree[v] == 0) {

                    q.offer(v);

                }     
                
            }  
            
        }
        
        return seenNodesCount == N ? answer : -1;
        
    }
}