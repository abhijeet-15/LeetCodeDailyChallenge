// https://leetcode.com/problems/check-completeness-of-a-binary-tree/ 

/* For bfs, because we are travelling left to right, if we encounter a null node, then further nodes should also be null
 * For dfs, in a Balanced Tree, for ith index, its left and right child's indexes are 2i+1 and 2i+2. If this index is >= total number of nodes
 * it is not a balanced tree
 */

 // dsf
class Solution {
    
    private int countNodes(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private boolean dfs(TreeNode root, int n, int idx) {
        
        if(root == null) return true;
        
        if(idx >= n) return false;
        
        return dfs(root.left,n,2*idx+1) && dfs(root.right,n,2*idx+2);
    }
    
    public boolean isCompleteTree(TreeNode root) {
        
        int n = countNodes(root);
        
        return dfs(root,n,0);
    }
}


// bfs

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        
        if(root == null) {
            return true;         
        }
        boolean nullNodeFound = false;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            
            if(node == null) {
                nullNodeFound = true;
            } else {
                if(nullNodeFound) {
                    return false;
                }
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return true;
    }
}