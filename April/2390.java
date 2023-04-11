// https://leetcode.com/problems/removing-stars-from-a-string/

//approach 1 using stack
class Solution {
    
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            
            if(s.charAt(i) == '*' && !st.isEmpty())
                st.pop();
            
            else 
                st.push(s.charAt(i));
            
        }
        
        StringBuilder result = new StringBuilder();
        
        while(!st.isEmpty()) {
            
            result.append(st.peek());
            st.pop();
            
        }
        
        return result.reverse().toString();
    }
}


//approach 2 using StringBuilder

class Solution {
    
    public String removeStars(String s) {
        
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            
            if(s.charAt(i) == '*') {
                
                result.deleteCharAt(result.length() - 1);
                
            }
            
            else {
                
                result.append(s.charAt(i));
                
            }
            
        }
        
        return result.toString();
    }
}

//two pointer approach
class Solution {
    
    public String removeStars(String s) {
        
        int n = s.length();
        char temp [] =  new char[n];
        
        int j=0;
        
        for(int i=0; i<n; i++) {
            
            if(s.charAt(i) == '*')
                j--;
            
            else {
                
                temp[j] = s.charAt(i);
                j++;
            }
            
        }
        
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i<j; i++) {
            result.append(temp[i]);
        }
        
        return result.toString();
        
    }
}