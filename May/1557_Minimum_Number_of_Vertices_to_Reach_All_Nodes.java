/*
 * https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/ 
 * 
 * Intution : Just count nodes with 0 indegree
 */

 class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        boolean[] inDegree = new boolean[n];
        List<Integer> result = new ArrayList<>();
        
        for(List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            
            // u--> v
            inDegree[v] = true;
        }
        
        for(int i=0; i<n; i++) {
            if(inDegree[i] == false) {
                result.add(i);
            }
        }
        return result;
    }
}