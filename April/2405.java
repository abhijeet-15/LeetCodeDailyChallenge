// https://leetcode.com/problems/optimal-partition-of-string/

class Solution {
    
    public int partitionString(String s) {
        
        int lastSeen [] = new int[26];
        
        Arrays.fill(lastSeen, -1);
        
        int count = 0;
        
        int currSubstrStart = 0;
        
        for(int i=0; i<s.length(); i++) {
            
            char ch = s.charAt(i);
            
            int idx = ch - 'a';
            
            if(lastSeen[idx] >= currSubstrStart) {
                
                count++;
                
                currSubstrStart = i;
              
            }
            
            lastSeen[idx] = i;
            
        }
        
        return count+1;
        
    }
}