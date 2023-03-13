// https://leetcode.com/problems/symmetric-tree/

// Time complexity is O(N) and space complexity is O(LogN) for the recursive stack used.

class Solution {

    private boolean isSymmetric(TreeNode root1, TreeNode root2){
        
        if(root1 == null && root2 == null) return true;
        if(root1 != null && root2 == null) return false;
        if(root1 == null && root2 != null) return false;
        if(root1.val != root2.val) return false;
        
        return isSymmetric(root1.left,root2.right) && isSymmetric(root1.right,root2.left);
        
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left,root.right);
    }
}