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


// bfs approach

class Solution {
    
    HashMap<Node, Node> mp;
    
    private void bfs(Queue<Node> q) {
              
        while(!q.isEmpty()) {
            
            Node node = q.peek();
            
            Node clone_node = mp.get(node);
            
            q.poll();
            
            for(Node n : node.neighbors) {
                
                if(!mp.containsKey(n)) {
                    
                    Node clone = new Node(n.val);
                    
                    mp.put(n, clone);
                    
                    clone_node.neighbors.add(clone);
                    
                    q.offer(n);
                    
                }
                
                else {
                    
                    clone_node.neighbors.add(mp.get(n));
                    
                }
                
            }
            
        }
        
    }
    
    public Node cloneGraph(Node node) {
        
        if(node == null) return null;
        
        this.mp = new HashMap<>();
        
        Node clone_node = new Node(node.val);
        
        mp.put(node, clone_node);
        
        Queue<Node> q = new LinkedList<>();
        
        q.offer(node);
        
        bfs(q);
        
        return clone_node;
        
    }
}