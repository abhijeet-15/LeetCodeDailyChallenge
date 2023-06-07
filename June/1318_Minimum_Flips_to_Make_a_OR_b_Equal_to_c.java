// 1318 https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/

//Approach 1
class Solution {
    public int minFlips(int a, int b, int c) {
        int flip = 0;
        while(a!=0 || b!=0 || c!=0) {
            
            if((c&1) == 0) {
                if((a&1) != 0) flip++;
                if((b&1) != 0) flip++;
            }
            
            if((c&1) == 1) {
                if((a&1) == 0 && (b&1) == 0) flip++;
            }
            
            a>>=1;
            b>>=1;
            c>>=1;
        }
        return flip;
    }
}

//Approach 2
class Solution {
    
    public int minFlips(int a, int b, int c) {
        int result = ((a|b)^c);
        
        int result1 = (a&b);
        int result2 = (result1&result);
        
        return Integer.bitCount(result) + Integer.bitCount(result2);
        
    }
}