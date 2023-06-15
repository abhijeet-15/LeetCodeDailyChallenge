// 1161 https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/ 

// DFS TC O(N) SC O(N)
class Solution {
    private int l = 0;
    private int[] sums = new int[10001];
    public void dfs(TreeNode root, int level) {
        l = Math.max(l,level);
        if(root == null) return;
        
        sums[level] += root.val;
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
    
    public int maxLevelSum(TreeNode root) {
        dfs(root,0);
        
        int ans = 0;
        int sum = sums[0];
        
        for(int i=1; i<l; i++) {
            if(sums[i] > sum) {
                sum = sums[i];
                ans = i;
            }
        }
        return ans+1;
    }
}

// BFS  TC O(N) SC O(N)
class Solution {
    int ans = 0;
    
    void bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int sum = -100001;
        int level = 0;
        
        q.offer(root);
        while(!q.isEmpty()) {
            int N = q.size();
            int currSum = 0;
            while(N-- > 0) { 
                TreeNode curr = q.peek();
                q.poll();
                currSum += curr.val;
                
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
                
            }
            ++level;
            if(currSum > sum) {
                sum = currSum;
                ans = level;
            }
        }
    }
    
    public int maxLevelSum(TreeNode root) {
        bfs(root);
        return ans;
    }
}