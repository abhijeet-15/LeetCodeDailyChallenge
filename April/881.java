// https://leetcode.com/problems/boats-to-save-people/


class Solution {
    
    public int numRescueBoats(int[] p, int l) {
        
        Arrays.sort(p);
        
        int i=0;
        int j=p.length-1;
        
        int ans = 0;
        
        while(i <= j) {
            
            if(p[i] + p[j] <= l) {
                i++;
            }
            
            j--;
            
            ans++;
            
        }
        
        return ans;
    }
}