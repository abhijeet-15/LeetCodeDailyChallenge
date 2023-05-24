//https://leetcode.com/problems/maximum-subsequence-score/

//recursion --> gives TLE with memo also

class Solution {
    private int k;
    private int n;
   
    private int solve(int[] nums1, int[] nums2, int sum, int min, int idx, int count) {
        
        if(count == k) {
            return sum*min;
        }
        
        if(idx >= n){
            return 0;
        }
        
        int curr_min = Math.min(nums2[idx],min);
        int take = solve(nums1,nums2,sum+nums1[idx], curr_min, idx+1, count+1);
        
        int notTake = solve(nums1,nums2,sum,min,idx+1,count);
        
        return Math.max(take, notTake);
        
    }
    
    public long maxScore(int[] nums1, int[] nums2, int k) {
        this.k = k;
        this.n = nums1.length;
        
        return solve(nums1,nums2,0,Integer.MAX_VALUE,0,0);
    }
}

//PQ -- Greedy
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] combined = new int[n][2];
        
        for(int i=0; i<n; i++) {
            combined[i] = new int[2];
            combined[i][0] = nums1[i];
            combined[i][1] = nums2[i];
        }
        
        Arrays.sort(combined, (a,b) -> b[1]-a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        
        long kSum=0;
        for(int i=0; i<k; i++){
            kSum += combined[i][0];
            pq.offer(combined[i][0]);
        }
        
        long result = kSum*combined[k-1][1];
        
        for(int i=k; i<n; i++) {
            //taking min as combined[i][1];
            
            kSum+=combined[i][0]-pq.peek();
            pq.poll();
            pq.offer(combined[i][0]);
            
            result = Math.max(result, kSum*combined[i][1]);
        }
        return result;
    }
}