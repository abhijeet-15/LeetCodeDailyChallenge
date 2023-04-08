// https://leetcode.com/problems/clone-graph/

class Solution {
    
    HashMap<Node, Node> mp;
    
    private void dfs(Node node, Node clone_node) {
        
        for(Node n : node.neighbors) {
            
            if(!mp.containsKey(n)) {
                
                Node clone = new Node(n.val);
                
                mp.put(n, clone);
                
                clone_node.neighbors.add(clone);
                
                dfs(n, clone);
                
            }
            
            else {
                
                clone_node.neighbors.add(mp.get(n));
                
            }
            
        }
        
    }
    
    public Node cloneGraph(Node node) {
        
        if(node == null) return null;
        
        this.mp = new HashMap<>();
        
        Node clone_node = new Node(node.val);
        
        mp.put(node, clone_node);
        
        dfs(node, clone_node);
        
        return clone_node;
        
    }
}