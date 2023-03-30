// https://leetcode.com/problems/scramble-string/ 

class Solution {
    
    private Map<String, Boolean> mp;
    
    private boolean solve(String s1, String s2) {
        
        
        if(s1.equals(s2)) return true;
        
        if(s1.length() != s2.length()) return false;
        
        String key = s1 + "_" + s2;
        
        if(mp.containsKey(key)) {
            
            return mp.get(key);
        }
        
        boolean result = false;
        
        int n = s1.length();
        
        for(int i=1; i<n; i++) {
            
            boolean swapped = solve(s1.substring(0,i), s2.substring(n-i,n)) && solve(s1.substring(i,n), s2.substring(0,n-i));
            
            if(swapped) {
                
                result = true;
                break;
            }
            
            boolean notSwapped = solve(s1.substring(0,i), s2.substring(0,i)) && solve(s1.substring(i,n), s2.substring(i,n));
            
            if(notSwapped) {
                
                result = true;
                break;
            
            }
            
        }
        
        mp.put(key,result);
        
        return result;
        
    }
    
    public boolean isScramble(String s1, String s2) {
        
        this.mp = new HashMap<>();
        
        return solve(s1,s2);
    }
    
}