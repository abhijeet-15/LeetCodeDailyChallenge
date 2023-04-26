// https://leetcode.com/problems/add-digits/

// approach 1 brute force log(n)

class Solution {

    public int addDigits(int num) {
        int sum = 0;
        
        while(num > 0) {
            sum += num%10;
            num = num/10;
            
            if(num == 0 && sum > 9) {
                num = sum;
                sum = 0;
            }
        }
        return sum;
    }
}

// Approach 2 --> Maths

/*
 * There is a known formaula. If num == 0, 0 . If num is divisible by 9 then 9 otherwise remainder of num divided by 9
 */

class Solution {
    
    public int addDigits(int num) {
        
        if(num == 0) return 0;
        if(num % 9 == 0) return 9;
        return num % 9;
    }
}