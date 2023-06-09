// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/

//approach 1
class Solution {
    private int maxi;
    
    private void solve(TreeNode root, int steps, boolean goLeft) {
        
        if(root == null)
            return;
        
        maxi = Math.max(maxi, steps);
        
        if(goLeft) {
            
            solve(root.left, steps+1, false);
            solve(root.right, 1, true);
        }
        
        else {
            
            solve(root.right, steps+1, true);
            solve(root.left, 1, false);
        }
    }
    
    public int longestZigZag(TreeNode root) {
        this.maxi = 0;
        
        solve(root,0,true);
        solve(root,0,false);
        
        return maxi;
    }
}

// approach 2

class Solution {
    
    private int maxi;
    
    private void solve(TreeNode root, int left, int right) {
        
        if(root == null) return;
        
        maxi = Math.max(maxi, Math.max(left, right));
        
        solve(root.left, right+1, 0);
        solve(root.right, 0 , left+1);
        
    }
    
    public int longestZigZag(TreeNode root) { 
        
        this.maxi = 0;
        solve(root,0,0);
        
        return maxi;
    }
}