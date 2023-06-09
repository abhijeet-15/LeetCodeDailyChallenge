/*
 * 744 https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 */

 // Binary Search O(log N) Space O(1)
 class Solution {
    public int bSearch(char[] l, char k) {
        int n = l.length;
        int s = 0;
        int e = n-1;
        int mid = s + (e-s)/2;
        int ans = -1;
        while(s<=e) {
            mid = s+(e-s)/2;
            if(l[mid] > k) {
                ans = mid;
                e=mid-1;
            }
            else {
                s=mid+1;
            }
        }
        return ans;
    }
    public char nextGreatestLetter(char[] letters, char target) {
        int idx = bSearch(letters,target);
        
        return idx==-1? letters[0] : letters[idx];
            
    }
}
