// https://leetcode.com/problems/find-the-difference-of-two-arrays/

/*
 *TC O(M+N)
  SC O(N)
 */

class Solution {
    
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        Set<Integer> presentInFirst = new HashSet<>();
        Set<Integer> presentInSecond = new HashSet<>();
        
        int m = nums1.length;
        int n = nums2.length;
        
        int i=0;
        
        while(i < Math.max(m, n)) {
            
            if(i < m) {
                presentInFirst.add(nums1[i]);
            }
            
            if(i < n) {
                presentInSecond.add(nums2[i]);
            }
            
            i++;
        }
        
        List<Integer> onlyInFirst = new ArrayList<>();
        List<Integer> onlyInSecond = new ArrayList<>();

        
        Iterator<Integer> it = presentInFirst.iterator();       
        while(it.hasNext()) {
            int e = it.next();
            if(!presentInSecond.contains(e)) {
                onlyInFirst.add(e);
            }
        }
        
        it = presentInSecond.iterator();       
        while(it.hasNext()) {
            int e = it.next();
            if(!presentInFirst.contains(e)) {
                onlyInSecond.add(e);
            }
        }
        
  
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(onlyInFirst);
        ans.add(onlyInSecond);
        
        return ans;
        
    }
}