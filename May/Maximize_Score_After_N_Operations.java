/*
 * 1799
 * https://leetcode.com/problems/maximize-score-after-n-operations/
 */

 //Recursive Backtracking --> TLE
 class Solution {
    private int n;
    
    private int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
    
    private int solve(int[] nums, boolean[] visited, int op) {
        int maxScore = 0;
        
        for(int i=0; i<n-1; i++) {
            
            if(visited[i]) 
                continue;
            
            for(int j=i+1; j<n; j++) {
                
                if(visited[j])
                    continue;
                
                visited[i] = true;
                visited[j] = true;
                
                int currScore = op * (gcd(nums[i], nums[j]));
                
                int remainingScore = solve(nums,visited,op+1);
                
                maxScore = Math.max(maxScore, (currScore + remainingScore));
                
                visited[i] = false;
                visited[j] = false;
            }
        }
        
        return maxScore;
    }
    
    public int maxScore(int[] nums) {
        
        this.n = nums.length;
        boolean[] visited = new boolean[n];
        
        return solve(nums,visited,1);
    }
}

// Memoisation
class Solution {
    private int n;
    
    private int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
    
    private int solve(int[] nums, boolean[] visited,  Map<String, Integer> dp, int op) {
        int maxScore = 0;
        
        String visitedString = Arrays.toString(visited);
        
        if(dp.containsKey(visitedString)) {
            return dp.get(visitedString);
        }
        
        for(int i=0; i<n-1; i++) {
            
            if(visited[i]) 
                continue;
            
            for(int j=i+1; j<n; j++) {
                
                if(visited[j])
                    continue;
                
                visited[i] = true;
                visited[j] = true;
                
                int currScore = op * (gcd(nums[i], nums[j]));
                
                int remainingScore = solve(nums,visited,dp,op+1);
                
                maxScore = Math.max(maxScore, (currScore + remainingScore));
                
                visited[i] = false;
                visited[j] = false;
            }
        }
        
        dp.put(Arrays.toString(visited),maxScore);
        
        return maxScore;
    }
    
    public int maxScore(int[] nums) {
        
        this.n = nums.length;
        boolean[] visited = new boolean[n];
        
        Map<String, Integer> dp = new HashMap<>();
        
        return solve(nums,visited,dp,1);
    }
}
