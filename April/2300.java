// https://leetcode.com/problems/successful-pairs-of-spells-and-potions/

class Solution {
    
    private int bSearch(int[] p, long min) {
        
        int n = p.length;
        int s=0, e=n-1;
        
        int ans = n;
        
        int mid = s + (e-s)/2;
        
        while(s <= e) {
            
            if(min <= p[mid]) {
                ans = mid;
                e = mid-1;
            }
            
            else {
                s = mid+1;
            }
            
            mid = s + (e-s)/2;
            
        }
       
        return n - ans;
    
    }
        
    
    public int[] successfulPairs(int[] s, int[] p, long success) {
        
        Arrays.sort(p);
        int n = s.length;
        
        int res[] =  new int[n];
        
        for(int i=0; i<n; i++) {
            
            long rem = success % s[i];
            long min = success / s[i] + (rem == 0 ? 0 : 1);
            
            int sIndex =  bSearch(p,min);
            
            res[i] = sIndex;
            
        }
        
        return res;
        
    }
}