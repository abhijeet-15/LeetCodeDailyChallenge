//https://leetcode.com/problems/merge-strings-alternately/

// two pointer approach
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder sb = new StringBuilder("");
        
        int i=0, j=0;
        while(i < m && j < n) {
            
            sb.append(word1.charAt(i)).append(word2.charAt(j));
            i++;
            j++;
            
        }
        
        while(i < m){
            sb.append(word1.charAt(i));
            i++;
        }
        
        while(j < n) {
            sb.append(word2.charAt(j));
            j++;
        }
        
        return sb.toString();
    }
}


// one pointer
class Solution {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int i=0;
        StringBuilder sb = new StringBuilder("");
        
        while(i < Math.max(m,n)) {
            
            if(i < m)
                sb.append(word1.charAt(i));
            if(i<n)
                sb.append(word2.charAt(i));
            
            i++;
        }
        
        return sb.toString();
    }
}