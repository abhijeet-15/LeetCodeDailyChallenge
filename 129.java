// https://leetcode.com/problems/sum-root-to-leaf-numbers/

class Solution {

    private int dfs(TreeNode root, int currSum) {
        
        if(root == null) {
            return 0;
        }
        
        currSum = currSum*10 + root.val;
        
        if(root.left == null && root.right == null) {
            return currSum;
        }
        
        return dfs(root.left,currSum) + dfs(root.right,currSum);
    }
    
    public int sumNumbers(TreeNode root) {
        
        return dfs(root,0);
    }
}