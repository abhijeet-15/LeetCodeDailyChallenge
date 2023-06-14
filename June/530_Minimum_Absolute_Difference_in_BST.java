// 530 https://leetcode.com/problems/minimum-absolute-difference-in-bst/

// TC O(N) SC O(N) --> recursive stack
class Solution {
    
    private int mini;
    TreeNode prev;
    
    public void solve(TreeNode root) {
        if(root == null) return;
        solve(root.left);
        if(prev != null) mini = Math.min(mini, root.val - prev.val);
        prev = root;
        solve(root.right);
    }
    
    public int getMinimumDifference(TreeNode root) {
        this.mini = Integer.MAX_VALUE;
        solve(root);
        return mini;
    }
}