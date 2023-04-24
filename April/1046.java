// https://leetcode.com/problems/last-stone-weight/

// approach 1 - sorting O(nlogn) space O(1)

class Solution {
    
    public int lastStoneWeight(int[] stones) {
        
        int n = stones.length;
        
        if(n < 2) return stones[0];
        
        for(int i=0; i<n;i++) {
            
            Arrays.sort(stones);
            
            if(stones[n-1] == stones[n-2]) {
                stones[n-1] = 0;
                stones[n-2] = 0;
            }
            
            else {
                stones[n-1] = stones[n-1] - stones[n-2];
                stones[n-2] = 0;
            }
        }
        
        return stones[n-1];
    }
}