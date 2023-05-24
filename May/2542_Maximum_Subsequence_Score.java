//https://leetcode.com/problems/maximum-subsequence-score/

//recursion --> gives TLE with memo also
class Solution {
    private int k;
    private int n;
    PriorityQueue<Integer> pq;
    
    private int solve(int[] nums1, int[] nums2, int sum, int min, int idx, int count) {
        
        if(count == k) {
            return sum*min;
        }
        
        if(idx >= n){
            return 0;
        }
        
        pq.offer(nums2[idx]);
        int take = solve(nums1,nums2,sum+nums1[idx], pq.peek(), idx+1, count+1);
        
        pq.remove(nums2[idx]);
        int notTake = solve(nums1,nums2,sum,min,idx+1,count);
        
        return Math.max(take, notTake);
        
    }
    
    public long maxScore(int[] nums1, int[] nums2, int k) {
        this.k = k;
        this.n = nums1.length;
        this.pq = new PriorityQueue<>();
        
        return solve(nums1,nums2,0,0,0,0);
    }
}