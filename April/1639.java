// https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/

// Approach 1 Rec + Memo
class Solution {
    
    private int m;
    private int k;
    
    private int dp[][];
    private int mod;
    
    private int solve(long freq[][], String target, int i, int j) {
        
        if(i == m)
            return 1;
        
        if(j == k)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        long notTaken = solve(freq,target,i,j+1) % mod;
        
        long taken =  (freq[target.charAt(i)-'a'][j] * solve(freq,target,i+1,j+1)) % mod;
        
        return dp[i][j] = (int)((notTaken + taken) % mod);  
    }
    
    public int numWays(String[] words, String target) {
        
        this.m = target.length();
        this.k = words[0].length();
        this.mod = 1000000007;
        
        this.dp = new int[1001][1001];
        for(int[] d : dp)
            Arrays.fill(d,-1);
        
        long freq[][] = new long[26][k];
        
        for(int col=0; col<k; col++) {
            for(String word : words) {
                
                char ch = word.charAt(col);
                freq[ch - 'a'][col]++;
            }
        }
        
        return solve(freq, target, 0, 0);
    }
}


// approach 2
class Solution {
    
    private int m;
    private int k;
    
    private int dp[][];
    private int mod;
   
    
    public int numWays(String[] words, String target) {
        
        this.m = target.length();
        this.k = words[0].length();
        this.mod = 1000000007;
        
        this.dp = new int[1001][1001];
        //dp[i][j] = total ways to form target of length i using dicts word of each length j
        
        long freq[][] = new long[26][k];
        
        for(int col=0; col<k; col++) {
            for(String word : words) {
                
                char ch = word.charAt(col);
                freq[ch - 'a'][col]++;
            }
        }
        
        dp[0][0] = 1;
        
        for(int i=0; i<=m; i++) {
            for(int j=0; j<=k; j++) {
                
                //not taken
                if(j < k)
                    dp[i][j+1] = (dp[i][j+1] + dp[i][j]) % mod;
                
                //taken
                if(i<m && j<k)
                    dp[i+1][j+1] = (int)(((dp[i+1][j+1] + dp[i][j]) * freq[target.charAt(i)-'a'][j]) %mod);
                
            }
        }
        
        return dp[m][k];
    }
}