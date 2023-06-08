// 1351 https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/

//Binary search approach TC O(nlogm)
class Solution {
    private int binarySearch(int[][] grid, int i) {
        int n = grid[i].length;
        int s=0;
        int e = n-1;
        int mid = s + (e-s)/2;
        int ans= -1;
        while(s<=e) {
            mid = s + (e-s)/2;
            if(grid[i][mid] < 0) {
                ans = mid;
                e=mid-1;
            }
            else {
                s=mid+1;
            }
        }
        return ans;
        
    }
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int count = 0;
        for(int i=0; i<n; i++) {
            int j = binarySearch(grid,i);
            if(j != -1)
                count += (grid[i].length - j);
        }
        return count;
    }
}
