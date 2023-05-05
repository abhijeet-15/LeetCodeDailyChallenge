// 1456 https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/ 

// TC O(N) SC O(1)

class Solution {
    
    private int isVowel(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return 1;
        return 0;
    }
    
    public int maxVowels(String s, int k) {
        
        int currCount = 0;
        for(int i=0; i<k; i++) {
            currCount += isVowel(s.charAt(i));
        }
        
        int ans = currCount;
        
        for(int i=k; i<s.length(); i++) {
            
            currCount -= isVowel(s.charAt(i-k));
            currCount += isVowel(s.charAt(i));
            
            ans = Math.max(ans, currCount);
            
        }
        
        return ans;
    }
}