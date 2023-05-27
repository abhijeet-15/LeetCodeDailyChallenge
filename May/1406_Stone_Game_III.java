// 1406 https://leetcode.com/problems/stone-game-iii/

//rec + Memo
class Solution {
    private int n;
    private int[] t;
    
    private int solve(int[] stones, int i) {
        if(i>=n)
            return 0;
        
        if(t[i]!=-1)
            return t[i];
        
        int result = stones[i]-solve(stones,i+1);
        if(i+1<n)
            result = Math.max(result, stones[i]+stones[i+1]-solve(stones,i+2));
        if(i+2<n)
            result = Math.max(result, stones[i]+stones[i+1]+stones[i+2]-solve(stones,i+3));
        return t[i]=result;      
    }
    
    public String stoneGameIII(int[] stones) {
        this.n = stones.length;
        this.t = new int[n+1];
        
        Arrays.fill(t,-1);
        
        int diff = solve(stones,0);
        if(diff>0)
            return "Alice";
        else if(diff<0)
            return "Bob";
        return "Tie";
        
    }
}

//Bottom up
class Solution {
    public String stoneGameIII(int[] stones) {
        int n = stones.length;
        int[] t = new int[n+1];
        for(int i=n-1; i>=0; i--){
            t[i]=stones[i]-t[i+1];
            if(i+2<n+1)
                t[i]=Math.max(t[i],stones[i]+stones[i+1]-t[i+2]);
            if(i+3<n+1)
                t[i]=Math.max(t[i],stones[i]+stones[i+1]+stones[i+2]-t[i+3]);
        }
        int diff=t[0];
        if(diff>0) return "Alice";
        else if(diff<0) return "Bob";
        return "Tie";
    }
}