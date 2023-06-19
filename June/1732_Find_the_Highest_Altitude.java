// https://leetcode.com/problems/find-the-highest-altitude/

// TC O(N) and space O(1)

class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int curr = 0;
        for(int i : gain) {
            curr = i + curr;
            ans = Math.max(ans,curr);
        }
        return ans;
    }
}